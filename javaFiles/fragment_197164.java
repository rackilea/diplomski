package com.conuretech.video_assembler;
import com.xuggle.xuggler.IContainerFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ANaim
 */
public class TestVideo {

    public static void main (String [] args)
    {
        if (args[0].equalsIgnoreCase("1"))
        {


          System.out.println("Testing xuggler...");
          XugglerJpegImagesToMpegVideo newjpegImagesToMpegVideo = new XugglerJpegImagesToMpegVideo(); 
    newjpegImagesToMpegVideo.setFrameRate(24);
    //duration in millisecs, for example 2 secs will be 2000 
    newjpegImagesToMpegVideo.setDurationPerFrame(2000);
    newjpegImagesToMpegVideo.setOutputFilenamePath("C:/Users/Public/Pictures/Sample_Pictures_2/video.mp4");
    List<String> jpegImages = new ArrayList<String>();
    jpegImages.add("C:/Users/Public/Pictures/Sample_Pictures_2/1.jpg");
    jpegImages.add("C:/Users/Public/Pictures/Sample_Pictures_2/2.jpg");
    jpegImages.add("C:/Users/Public/Pictures/Sample_Pictures_2/3.jpg");
    jpegImages.add("C:/Users/Public/Pictures/Sample_Pictures_2/4.jpg");
    jpegImages.add("C:/Users/Public/Pictures/Sample_Pictures_2/5.jpg");
    jpegImages.add("C:/Users/Public/Pictures/Sample_Pictures_2/6.jpg");
    jpegImages.add("C:/Users/Public/Pictures/Sample_Pictures_2/7.jpg");
    jpegImages.add("C:/Users/Public/Pictures/Sample_Pictures_2/8.jpg");
    newjpegImagesToMpegVideo.setJpegFilePathList(jpegImages);
    newjpegImagesToMpegVideo.convertJpegFramesToMpegVideo();

    }     

        else
        {

        }

         System.exit(0);
}

}//end main