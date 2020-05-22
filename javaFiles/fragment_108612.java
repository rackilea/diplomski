public void run() throws Exception {

//File directory
File dir = Environment.getExternalStorageDirectory();
File file = new File(dir, "PDFs/result1.pdf");
if(file.canRead()){
    Log.d("file", "can read");
}else {Log.d("file","cant read");};


// Final request body
RequestBody requestBody = new MultipartBody.Builder()
        .setType(MultipartBody.FORM)
        .addFormDataPart("content","result1.pdf",RequestBody.create(MediaType.parse("application/pdf"), file))
        .build();

//URL Parameters
HttpUrl url = new HttpUrl.Builder()
        .scheme("https")
        .host("www.google.com")
        .addPathSegments("cloudprint/submit")
        .addQueryParameter("printerid", "82d70sde-694b-3385-f263-164cb04320c3")
        .build();

Request request = new Request.Builder()
        .header("Authorization", "OAuth ya29.Cl0jAxDuQni_Dskz6Y2r-wRaJVMxEw8fy5hPNfAm02pDLnZc9HX-RfHpmMoS0OL-Wv_SKxBtYIwRK9jVpJDwl7Qs-RFt02Qc5Yoid4w1kV8b4vBIpcleIQ8lBEto")
        .url(url)
        .post(requestBody)
        .build();

client.newCall(request)
        .enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, IOException e) {
                // Error

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // For the example, you can show an error dialog or a toast
                        // on the main UI thread
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                String res = response.body().string();

                // Do something with the response
            }
        });
}