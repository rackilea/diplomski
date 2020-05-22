String fileName="SOMEFILENAME.txt";
String str="this is the string you will see inside the file";
            try {
                FileOutputStream outputStream=openFileOutput(fileName,MODE_WORLD_READABLE);
                OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream);
                outputStreamWriter.write(str);
                outputStreamWriter.flush();
                outputStreamWriter.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO: handle exception
                e.printStackTrace();
            }