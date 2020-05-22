public class AsyncTaskConnection extends AsyncTask<String, String, Object>{
    JSONObject mainObject;
    Context mContext;
    String returnFunctionName;

    public AsyncTaskConnection (Context context){
         mContext = context;
    }

    protected void onPreExecute() {
        // preExecute
    }

    @Override
    protected Object doInBackground(String... arguments) {
        String apiFunctionName = arguments[0]; // get api FunctionName 
        String jsonString = arguments[1]; // get data
        returnFunctionName = apiFunctionName+"Response"; // return function name
        // some connection code...


        //then call...
            try {
                ht.call(NAMESPACE, requestEnvelop);
            } catch (IOException ex) {
                Log.d(mContext.getClass().getName(), "Io exception bufferedIOStream closed" + ex);
                ex.printStackTrace();
            }
            return mainObject.toString();
        } catch (Exception e) {
            Log.d("Exception", e.toString());
            return "no";
        }
    }

    // main thing is there, i have use the reflaction here....

    @Override
    protected void onPostExecute(Object backresult) {
        Method m;
        try {

            m = mContext.getClass().getDeclaredMethod(returnFunctionName, String.class);
            m.invoke(mContext, (String) backresult);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }