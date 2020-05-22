public class PostDataTask extends AsyncTask<String, Void, Integer>{

    @Override
    protected Integer doInBackground(String... params) {
        HttpRequest mReq = new HttpRequest();
        String data = "entry_272641491=" + URLEncoder.encode(params[1]) + "&" +
                "entry_130393492=" + URLEncoder.encode(params[2]);
        String response = mReq.sendPost(params[0], data);
        return 200;
    }
}