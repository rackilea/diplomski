@Override
        protected void onPreExecute() {
            super.onPreExecute();
            streets_progress.setVisibility(View.VISIBLE);
        }
@Override
        protected void onPostExecute(JSONObject result) {
            if (result!=null) {
            streets_progress.setVisibility(View.GONE);
        }