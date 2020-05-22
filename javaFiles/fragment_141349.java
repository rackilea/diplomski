String getURL = "https://www.google.com/speech-api/v1/recognize?client=chromium&lang=pt-PT&maxresults=10";
HttpPost get = new HttpPost(getURL);
get.setHeader("Content-Type", " audio/x-flac; rate=16000;");
get.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_6_8) AppleWebKit/535.7 (KHTML, like Gecko) Chrome/16.0.912.77 Safari/535.7");

List<NameValuePair> formparams = new ArrayList<NameValuePair>();
formparams.add(new BasicNameValuePair("param1", "paramValue1")); // name and value of your param
formparams.add(new BasicNameValuePair("param2", paramValue2));  // name and value of your param
// and so on
// create the encoded form
UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
// set it in the post request
get.setEntity(entity);