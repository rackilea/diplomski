try {
                    HttpClient httpclient = new DefaultHttpClient();
                    /*
                     * HttpPost(parameter): Server URI
                     */
                    HttpPost httppost = new HttpPost(SERVER_UPLOAD_URI);
                    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    HttpResponse response = httpclient.execute(httppost);
                    the_string_response = convertResponseToString(response);
                } catch (Exception e) {
                    Toast.makeText(UploadImageActivity.this, "ERROR " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                    System.out.println("Error in http connection " + e.toString());
                }