class UploadTask extends AsyncTask<String, String, Map<String, String>> {

    private Exception exception;

    protected Map<String, String> doInBackground(String... params) {
        Map response = ObjectUtils.asMap();
        try{

            response = cloudinary.uploader().upload(<Image file>,
                    ObjectUtils.asMap("resource_type", "image",
                    "public_id", <"somePublicId">));

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return response;
    }

    protected void onPostExecute(Map<String, String> response) {
        // TODO: handle the response


    }
}