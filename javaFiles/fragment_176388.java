private void copyRawFile() {


                InputStream in = null;
                OutputStream out = null;
    String filename="myFile"; //sd card file name           
    try {
//Provide the id of raw file to the openRawResource() method
                  in = getResources().openRawResource(R.raw.brawler);
                  out = new FileOutputStream("/sdcard/" + filename);
                  copyFile(in, out);
                  in.close();
                  in = null;
                  out.flush();
                  out.close();
                  out = null;
                } catch(Exception e) {
                    Log.e("tag", e.getMessage());
                }       

        }
        private void copyFile(InputStream in, OutputStream out) throws IOException {
            byte[] buffer = new byte[1024];
            int read;
            while((read = in.read(buffer)) != -1){
              out.write(buffer, 0, read);
            }
        }