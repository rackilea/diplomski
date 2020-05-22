String path =SCREENSHOT_FOLDER2; 

            File folder = new File(path);


                listOfFiles = folder.listFiles();  
                if(listOfFiles.length>0)
                {









              iplimage = new opencv_core.IplImage[listOfFiles.length];


               for (int j = 0; j < listOfFiles.length; j++) {

                 String files="";       

               if (listOfFiles[j].isFile()) 
               {
               files = listOfFiles[j].getName();

                 }   


                String[] tokens = files.split("\\.(?=[^\\.]+$)");
               String name=tokens[0]; 

                System.out.println(" j " + name);




              iplimage[j]=cvLoadImage("/mnt/sdcard/images/"+name+".png");


               }

            } 



                File videopath = new File(SCREENSHOT_FOLDER3);
                videopath.mkdirs();
                 newFFmpegFrameRecord recorder = new newFFmpegFrameRecord(SCREENSHOT_FOLDER3+"video"+System.currentTimeMillis()+".mp4",320,480);

                 try {
                     recorder.setCodecID(CODEC_ID_MPEG4); //CODEC_ID_MPEG4       
                     //CODEC_ID_MPEG1VIDEO
                     recorder.setBitrate(sampleVideoBitRate);
                     recorder.setFrameRate(10);                     
                     recorder.setPixelFormat(PIX_FMT_YUV420P); //PIX_FMT_YUV420P


                     recorder.start();

                     int x = 0;
                     int y = 0;
                    for (int i=0;i< 300 && x<iplimage.length;i++)

                       {

                         recorder.record(image[x]);

                        if (i>(y+10)) {
                            y=y+1;
                            x++;
                        }

                        }
                     recorder.stop();
                    }
                 catch (Exception e){
                     e.printStackTrace();
                   }