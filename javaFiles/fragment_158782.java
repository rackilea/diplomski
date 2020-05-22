JSONObject args = new JSONObject();
args.put("Area", editTextPrice.getText().toString());
args.put("Description", editTextDescription.getText().toString())

ByteArrayOutputStream baos = new ByteArrayOutputStream();  
bm.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object   
byte[] b = baos.toByteArray();

String encodedImage = Base64.encodeToString(b , Base64.DEFAULT);
args.put("image",encodedImage);

//You can also use NameValuePair instead JSON
//like : nameValuePairs.add(new BasicNameValuePair("Area", editTextPrice.getText().toString());
List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
nameValuePairs.add(new BasicNameValuePair("data", arg.toString()));

httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));

// Execute HTTP Post Request
HttpResponse response = httpclient.execute(httppost);