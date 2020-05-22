public class DownloadTask extends AsyncTask<String, Integer, String> {
ProgressDialog mProgressDialog;
        private Context context;
        private PowerManager.WakeLock mWakeLock;
        String fileName=null;
        public DownloadTask(Context context,ProgressDialog Dialog) {
            this.context = context;
            this.mProgressDialog=Dialog;
        }

        @Override
        protected String doInBackground(String... sUrl) {
            InputStream input = null;
            OutputStream output = null;
            HttpURLConnection connection = null;
            try {
                URL url = new URL(sUrl[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.setReadTimeout(3000);
                connection.setConnectTimeout(5000);
                connection.connect();

                if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    return "Server returned HTTP " + connection.getResponseCode()
                            + " " + connection.getResponseMessage();
                }


                String raw = connection.getHeaderField("Content-Disposition");

             if(raw != null && raw.indexOf("=") != -1) {
                  fileName = raw.split("=")[1];
                  fileName=fileName.split(";")[0];
                  fileName=fileName.substring(1, fileName.length()-1);
             } else {

             }
                File f=new File(context.getFilesDir()+"/"+fileName);
               if(!f.exists())
               {Log.d("TAG","DOES NOT EXIST , downloading");

                int fileLength = connection.getContentLength();

                input = connection.getInputStream();

                Log.d("Tag", raw);
                Log.d("Tag",fileName);
                output = new FileOutputStream(context.getFilesDir()+"/"+fileName);

                byte data[] = new byte[4096];
                long total = 0;
                int count;
                while ((count = input.read(data)) != -1) {

                    if (isCancelled()) {
                        input.close();
                        File check =new File(context.getFilesDir()+"/"+fileName);
                        check.delete();
                        return null;
                    }
                    total += count;

                    if (fileLength > 0) 
                        publishProgress((int) (total * 100 / fileLength));
                    output.write(data, 0, count);
                }
            } }catch (Exception e) {
                return e.toString();
            } finally {
                try {
                    if (output != null)
                        output.close();
                    if (input != null)
                        input.close();
                } catch (IOException ignored) {
                }

                if (connection != null)

                    connection.disconnect();


            }
            return null;


        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                 getClass().getName());
            mWakeLock.acquire();
            mProgressDialog.show();
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            super.onProgressUpdate(progress);

            mProgressDialog.setIndeterminate(false);
            mProgressDialog.setMax(100);
            mProgressDialog.setProgress(progress[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            mWakeLock.release();
            mProgressDialog.dismiss();
            if (result != null)
            {File file=new File(context.getFilesDir()+File.separator+fileName);
            file.delete();
                Toast.makeText(context,"Download error: "+"Please check your internet connection!", Toast.LENGTH_LONG).show();
            }
    //**THIS IS THE CHANGE**           else
            { SharedPreferences p=PreferenceManager.getDefaultSharedPreferences(context);
            Editor editor=p.edit();
           editor.putString(fileName, "DONE");
           editor.commit();


                    Toast.makeText(context,"File downloaded", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(context,MuPDFActivity.class);
            Uri uri=Uri.parse(context.getFilesDir()+"/"+fileName);
            i.setAction(Intent.ACTION_VIEW);
            i.setData(uri);
            context.startActivity(i);
            }
        }}