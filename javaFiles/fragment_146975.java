public class PageLoader extends AsyncTask<String, Void, String[] results> {

    private Context context;
    private LoaderListener mLoaderListener;

    public PageLoader(Context context, LoaderListener mLoaderListener) {
        this.context = context;
        this.mLoaderListener = mLoaderListener;
    }

    public interface LoaderListener {
        void onLoadCompleted(String[] results);

        void onLoadFailed();

        void onPreparing();
    }

    @Override
    protected void onPreExecute() {
        mLoaderListener.onPreparing();
    }

    @Override
    protected String[] doInBackground(String... params) {
         try {
            URL url=new URL(URL_Path);
            connection= (HttpURLConnection) url.openConnection();
            connection.connect();


            InputStream inputStream=connection.getInputStream();
            reader=new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuffer stringBuffer=new StringBuffer();
            while ((line=reader.readLine())!=null){
                stringBuffer.append(line);

            }
            String completeJSON=stringBuffer.toString();

            JSONArray parentArray=new JSONArray(completeJSON);

            String[] Name=new String[parentArray.length()];
            String[] ImagePath=new String[parentArray.length()];
            for (int i = 0; i <parentArray.length() ; i++) {
                JSONObject childObject=parentArray.getJSONObject(i);

                String Fname=childObject.getString("First_Name") ;
                String Lname=childObject.getString("Last_Name") ;

                Name[i]=Fname+" "+Lname;
                ImagePath[i]=childObject.getString("Image");
                Log.d(TAG,"String Arrays "+Name[i]+" "+ ImagePath[i]);

                     //GETTING ALL VALUES IN LOG SUCCESSFULLY 



            }
            return Name;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {

            try {
                connection.disconnect();
                if (reader!=null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onPostExecute(String[] results) {
        if (results!= null) {
            mLoaderListener.onLoadCompleted(results);
        } else {
            mLoaderListener.onLoadFailed();
        }
    }


}