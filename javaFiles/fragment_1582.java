import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DirectColorModel;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.WritableRaster;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class SparseBufferedImageTest
{
    public static void main(String[] args)
    {
        SparseBufferedImage.PRINT_DATA_SIZE = true;

        SparseBufferedImage sbi = new SparseBufferedImage(1000, 1000);

        Graphics2D g = sbi.createGraphics();
        g.setColor(Color.BLACK);
        g.drawString("Test", 20, 20);

        g.setColor(Color.RED);
        g.fillOval(300, 300, 40, 40);

        g.setColor(Color.GREEN);
        g.fillRect(600, 700, 20, 20);

        g.setColor(Color.BLUE);
        g.drawLine(200, 800, 800, 200);

        g.dispose();

        show(sbi);
    }

    private static void show(final BufferedImage b)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.getContentPane().add(new JLabel(new ImageIcon(b)));
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }
}



/**
 * A BufferedImage that is backed by a sparse int buffer
 */
class SparseBufferedImage extends BufferedImage
{
    public static boolean PRINT_DATA_SIZE = false;

    // Constants for the Red, Green and Blue band masks
    // for the type BufferedImage.TYPE_INT_RGB
    private static final int MASK_RGB_RED   = 0x00ff0000;
    private static final int MASK_RGB_GREEN = 0x0000ff00;
    private static final int MASK_RGB_BLUE  = 0x000000ff;

    // Constants for the Red, Green and Blue band masks
    // for the type BufferedImage.TYPE_INT_BGR
    private static final int MASK_BGR_RED   = 0x000000ff;
    private static final int MASK_BGR_GREEN = 0x0000ff00;
    private static final int MASK_BGR_BLUE  = 0x00ff0000;

    // Constants for the Red, Green and Blue band masks
    // for the type BufferedImage.TYPE_INT_ARGB
    private static final int MASK_ARGB_ALPHA = 0xff000000;
    private static final int MASK_ARGB_RED   = 0x00ff0000;
    private static final int MASK_ARGB_GREEN = 0x0000ff00;
    private static final int MASK_ARGB_BLUE  = 0x000000ff;

    /**
     * Creates a new SparseBufferedImage with the given size
     * and the type BufferedImage.TYPE_INT_RGB
     * 
     * @param width The width
     * @param height The height
     */
    public SparseBufferedImage(int width, int height)
    {
        this(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    /**
     * Creates a new SparseBufferedImage with the given size.
     * 
     * @param width The width
     * @param height The height
     * @param type The type. MUST be BufferedImage.TYPE_INT_BGR or
     * BufferedImage.TYPE_INT_RGB 
     */
    public SparseBufferedImage(int width, int height, int type)
    {
        super(
            createColorModel(type), 
            createPackedRaster(
                new SparseDataBufferInt(width * height), 
                width, height, createBandmasks(type)), 
                false, new Hashtable<Object, Object>());
    }

    /**
     * Create the band masks for the R,G and B components
     * 
     * @param type The type. MUST be BufferedImage.TYPE_INT_BGR or
     * BufferedImage.TYPE_INT_RGB 
     * @return The band masks
     */
    private static int[] createBandmasks(int type)
    {
        if (type == BufferedImage.TYPE_INT_RGB)
        {
            int bandmasks[] = new int[3];
            bandmasks[0] = MASK_RGB_RED;
            bandmasks[1] = MASK_RGB_GREEN;
            bandmasks[2] = MASK_RGB_BLUE;
            return bandmasks;
        }
        else if (type == BufferedImage.TYPE_INT_BGR)
        {
            int bandmasks[] = new int[3];
            bandmasks[0] = MASK_BGR_RED;
            bandmasks[1] = MASK_BGR_GREEN;
            bandmasks[2] = MASK_BGR_BLUE;
            return bandmasks;
        }
        else if (type == BufferedImage.TYPE_INT_ARGB)
        {
            int bandmasks[] = new int[4];
            bandmasks[0] = MASK_ARGB_RED;
            bandmasks[1] = MASK_ARGB_GREEN;
            bandmasks[2] = MASK_ARGB_BLUE;
            bandmasks[3] = MASK_ARGB_ALPHA;
            return bandmasks;
        }
        throw new IllegalArgumentException("Invalid image type: "+type);
    }

    /**
     * Creates a direct 24bit color model
     * 
     * @param type The type. MUST be BufferedImage.TYPE_INT_BGR or
     * BufferedImage.TYPE_INT_RGB 
     * @return The color model
     */
    private static ColorModel createColorModel(int type)
    {
        if (type == BufferedImage.TYPE_INT_RGB)
        {
            ColorModel colorModel = new DirectColorModel(24, 
                MASK_RGB_RED, MASK_RGB_GREEN, MASK_RGB_BLUE, 0x0);
            return colorModel;
        }
        else if (type == BufferedImage.TYPE_INT_BGR)
        {
            ColorModel colorModel = new DirectColorModel(24, 
                MASK_BGR_RED, MASK_BGR_GREEN, MASK_BGR_BLUE, 0x0);
            return colorModel;
        }
        else if (type == BufferedImage.TYPE_INT_ARGB)
        {
            ColorModel colorModel = new DirectColorModel(32, 
                MASK_ARGB_RED, MASK_ARGB_GREEN, MASK_ARGB_BLUE, MASK_ARGB_ALPHA);
            return colorModel;
        }
        throw new IllegalArgumentException("Invalid image type: "+type);
    }

    /**
     * Creates a new SparseIntegerInterleavedRaster, which is a
     * simplified WritableRaster backed by the given buffer and
     * with the given size. 
     * 
     * @param dataBuffer The data buffer
     * @param w The width
     * @param h The height
     * @param bandMasks The band masks
     * @return The WritableRaster
     */
    private static WritableRaster createPackedRaster(
        SparseDataBufferInt dataBuffer, int w, int h, int bandMasks[])
    {
        SinglePixelPackedSampleModel singlePixelPackedSampleModel = 
            new SinglePixelPackedSampleModel(
                dataBuffer.getDataType(), w, h, w, bandMasks);

        return new SparseIntegerInterleavedRaster(
            singlePixelPackedSampleModel, dataBuffer);
    }

    /**
     * A DataBuffer backed by a sparse IntBuffer
     */
    private static class SparseDataBufferInt extends DataBuffer
    {
        /** The default data bank. */
        private SparseIntBuffer data;

        /**
         * Constructs an integer-based DataBuffer with a single bank
         * and the specified size.
         * 
         * @param size The size of the DataBuffer.
         */
        public SparseDataBufferInt(int size)
        {
            super(TYPE_INT, size);
            data = new SparseIntBuffer();
        }

        SparseIntBuffer getData()
        {
            return data;
        }

        @Override
        public int getElem(int i)
        {
            return data.get(i + offset);
        }

        @Override
        public int getElem(int bank, int i)
        {
            return data.get(i + offsets[bank]);
        }

        @Override
        public void setElem(int i, int val)
        {
            data.put(i + offset, val);
        }

        @Override
        public void setElem(int bank, int i, int val)
        {
            data.put(i + offsets[bank], val);
        }

    }

    /**
     * A simplified WritableRaster that is backed by a SparseDataBufferInt.
     * Only for internal usage - some operations are not supported.
     */
    private static class SparseIntegerInterleavedRaster extends WritableRaster
    {
        private SparseDataBufferInt data;

        /**
         * Constructs a SparseIntegerInterleavedRaster with the given 
         * SampleModel and SparseDataBufferInt. 
         * 
         * @param sampleModel The SampleModel that specifies the layout.
         * @param dataBuffer The buffer that contains the image data.
         */
        public SparseIntegerInterleavedRaster(
            SampleModel sampleModel, SparseDataBufferInt dataBuffer)
        {
            super(
                sampleModel, dataBuffer, 
                new Rectangle(
                    0,0, 
                    sampleModel.getWidth(), 
                    sampleModel.getHeight()), 
                new Point(0,0), null);
            this.data = dataBuffer;
        }


        @Override
        public Object getDataElements(int x, int y, Object obj)
        {
            int outData[];
            if (obj == null)
            {
                outData = new int[1];
            }
            else
            {
                outData = (int[])obj;
            }
            int off = y * width + x;
            outData[0] = data.getData().get(off);
            return outData;
        }

        @Override
        public void setDataElements(int x, int y, Object obj)
        {
            int inData[] = (int[])obj;
            int off = y * width + x;
            data.getData().put(off, inData[0]);
        }
    }

    /**
     * Simple implementation of a sparse int buffer, backed
     * by a map
     */
    private static class SparseIntBuffer
    {
        private final Map<Integer, Integer> map = 
            new HashMap<Integer, Integer>();

        /**
         * Return the value at the given index, or 0
         * if there is no value stored
         * 
         * @param index The index
         * @return The value at the given index
         */
        int get(int index)
        {
            Integer value = map.get(index);
            if (value == null)
            {
                return 0;
            }
            return value;
        }

        /**
         * Set the value at the given index
         * 
         * @param index The index
         * @param value The value
         */
        void put(int index, int value)
        {
            map.put(index, value);

            if (PRINT_DATA_SIZE)
            {
                System.out.println("Put "+value+" at "+index+", size "+map.size());
            }
        }

    }

}