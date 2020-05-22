int factor=1;
                Image image=new Image(part.getInputStream());

                log.info("the file name is "+fileName);
                //resizing image using a factor
                if ((fileSizeInMB>2)&&(fileSizeInMB)<=4)//if the size is between 2 and 4
                {
                    factor=3;
                    image.resize(image.getWidth()/factor, image.getHeight()/factor);

                    image.saveAs(saveDirectory
                            + emaReceiverUtility.getNameOfAttachment(emailMessage)
                            + "_" + fileName);

                }