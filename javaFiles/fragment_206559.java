void takeScreenShot()
        {
            try
            {
                int num = 0;
                String fileName = "SS"+NAME.getMethodName()+".png";//name of file/s you wish to create
                String dir = "src/test/screenshot";//directory where screenshots live

                new File(dir).mkdirs();//makes new directory if does not exist
                File myFile = new File(dir,fileName);//creates file in a directory n specified name

                while (myFile.exists())//if file name exists increment name with +1
                {
                   fileName = "SS"+NAME.getMethodName()+(num++)+".png";
                   myFile = new File(dir,fileName);
                }

                FileOutputStream out = new FileOutputStream(myFile);//creates an output for the created file
                out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));//Takes screenshot and writes the screenshot data to the created file
                //FileOutputStream out = new FileOutputStream("target/surefire-reports/" + fileName);
                out.close();//closes the outputstream for the file
            }
            catch (Exception e)
            {
                // No need to crash the tests if the screenshot fails
            }