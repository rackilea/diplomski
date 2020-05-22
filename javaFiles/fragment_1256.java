void downloadFile(String vidN){
int downloadedSize = 0;
int totalSize = 0;
            try {
                // here vidN is the name of the file like bird.mp4
                // here sitepath is the path of the file
                URL url = new URL(sitepath+vidN);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                urlConnection.setRequestMethod("GET");
                urlConnection.setDoOutput(true);

                //connect
                urlConnection.connect();

                //set the path where we want to save the file 

                String RootDir = Environment.getExternalStorageDirectory()
                        + File.separator + "VideoNR2";
                File RootFile = new File(RootDir);
                RootFile.mkdir();



                //create a new file, to save the downloaded file 
                File file = new File(RootDir,""+vidN);

                FileOutputStream fileOutput = new FileOutputStream(file);

                //Stream used for reading the data from the internet
                InputStream inputStream = urlConnection.getInputStream();

                //this is the total size of the file which we are downloading
                totalSize = urlConnection.getContentLength();


                //create a buffer...
                byte[] buffer = new byte[1024];
                int bufferLength = 0;

                while ( (bufferLength = inputStream.read(buffer)) > 0 ) {
                    fileOutput.write(buffer, 0, bufferLength);
                    downloadedSize = bufferLength;
                         }
                //close the output stream when complete //
                fileOutput.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            catch (Exception e) {

            }       
        }