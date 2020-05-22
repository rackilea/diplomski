protected String doInBackground(String... f_url) {
        try {
            long total = 0;
            URL url = new URL(f_url[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

           /* if (file.exists())
            {
                connection.setAllowUserInteraction(true);
                connection.setRequestProperty("Range", "bytes=" + lenghtOfFile + "-");
            }*/

            if(file.exists()){
                deneme = file.length();
                connection.setRequestProperty("Range", "bytes="+(file.length())+"-");
            }
        else{
            connection.setRequestProperty("Range", "bytes=" + deneme + "-");
        }

            String connectionField = connection.getHeaderField("content-range");

            if (connectionField != null)
            {
                String[] connectionRanges = connectionField.substring("bytes=".length()).split("-");
                deneme = Long.valueOf(connectionRanges[0]);
            }

            if (connectionField == null && file.exists())
                file.delete();




            connection.setConnectTimeout(14000);
            connection.setReadTimeout(20000);
            connection.connect();



            long lenghtOfFile = connection.getContentLength() + deneme;
            RandomAccessFile output = new RandomAccessFile(file,"rw");
            BufferedInputStream input = new BufferedInputStream(connection.getInputStream());
            output.seek(deneme);
            byte data[] = new byte[1024];
            int lastcount = 0;


            while ((count = input.read(data,0,1024)) != -1) {

                if (isCanceled) { // this code waiting the click button :)
                    file.delete();
                    downloadresult = false;
                    break;
                }
                if (intCheck()) { // check internet and download
                    total += count;
                    downloadresult = true;
                    int ProgBarCount = (int) ((total * 100) / lenghtOfFile);
                    if (ProgBarCount > lastcount) {
                        lastcount = ProgBarCount;
                        publishProgress(Integer.toString(ProgBarCount));
                    }
                    output.write(data, 0, count);


                }


            }

           // output.flush();
            output.close();
            input.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            exmessage = e.getMessage().toString();
            downloadresult = false;

        }
        return null;
    }