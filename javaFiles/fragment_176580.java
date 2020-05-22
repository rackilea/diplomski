import com.google.zxing.NotFoundException;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.Reader;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.Result;
import com.google.zxing.LuminanceSource;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.*;

import com.google.zxing.qrcode.QRCodeReader;

class qr
{
    public static void main(String args[])
    {
        Reader xReader = new QRCodeReader();
        BufferedImage dest = null;

        try
        {
            dest = ImageIO.read(new File(args[0]));
        }
        catch(IOException e)
        {
            System.out.println("Cannot load input image");
        }
        LuminanceSource source = new BufferedImageLuminanceSource(dest);

        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Vector<BarcodeFormat> barcodeFormats = new Vector<BarcodeFormat>();
        barcodeFormats.add(BarcodeFormat.QR_CODE);

        HashMap<DecodeHintType, Object> decodeHints = new HashMap<DecodeHintType, Object>(3);
        decodeHints.put(DecodeHintType.POSSIBLE_FORMATS, barcodeFormats);

        decodeHints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);

        Result result = null;

        try
        {
            result = xReader.decode(bitmap, decodeHints);
            System.out.println("Code Decoded");
            String text = result.getText();
            System.out.println(text);
        }
        catch(NotFoundException e)
        {
            System.out.println("Decoding Failed");
        }
        catch(ChecksumException e)
        {
            System.out.println("Checksum error");
        }
        catch(FormatException e)
        {
            System.out.println("Wrong format");
        }
    }
}