import ij.*;
import ij.process.*;
import ij.gui.*;
import java.util.*;
import java.awt.*;
import ij.plugin.filter.*;
import ij.process.*;
import java.lang.Math.*;
import java.awt.image.IndexColorModel;


public class colortable_plugin implements PlugInFilter {

    public int setup(String arg, ImagePlus im) {
        return DOES_8C; // this plugin works on indexed color images
        }

    public void run(ImageProcessor ip) {

        IndexColorModel icm = (IndexColorModel) ip.getColorModel();             
        int pixBits = icm.getPixelSize();
        int mapSize = icm.getMapSize();

        //retrieve the current lookup tables (maps) for R,G,B
        byte[] Rmap = new byte[mapSize]; icm.getReds(Rmap);
        byte[] Gmap = new byte[mapSize]; icm.getGreens(Gmap);
        byte[] Bmap = new byte[mapSize]; icm.getBlues(Bmap);

        int[]   RGB = new int[3];
        int[][] allRGB = new int[256][3];
        //put color in rectangle
        for (int idx = 0; idx < mapSize; idx++){    
            int r = 0xff & Rmap[idx]; //mask to treat as unsigned byte
            int g = 0xff & Gmap[idx];
            int b = 0xff & Bmap[idx];
            RGB[0] = r;
            RGB[1] = g;
            RGB[2] = b;

            //save all RGB as array
            for(int k=0;k<3;k++){
                allRGB[idx][k]= RGB[k];
            }                               
        }       
        tbl(allRGB);


    }

    private void tbl(int[][] allRGB){

        ImageProcessor newip =new ColorProcessor(16,16);
        int count = 0 ;
        for(int i=0;i<16;i++){
            for(int j=0;j<16;j++){              
                newip.putPixel(i,j,allRGB[count]);count++;
            }
        }                           
        ImagePlus cwin = new ImagePlus("TBL", newip);
        IJ.run(cwin, "Size...", "width=256 height=256 constrain interpolation=None");
        cwin.show();          
    }

}