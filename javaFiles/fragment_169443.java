@Override
protected String doInBackground(String... params) {
    return getXMLFromUrl(params[0]);
}

@Override protected void onPostExecute(String result) {
     if(result != null) {
     String xml = result;
     Document doc = getDomElement(xml);
            NodeList nl = doc.getElementsByTagName(KEY_ITEM);
            Element e = (Element) nl.item(z);
            String successString = getValue(e,KEY_SUCCESS);
            String UIDString = getValue(e,KEY_UID);
            String failString = getValue(e,KEY_FAIL);
            String loginError = "Please check username and password.";
            if(failString.equals("Fail")){
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(MainActivity.this, loginError, duration);
                toast.setGravity(Gravity.TOP|Gravity.RIGHT, 0, 0);
                toast.show();
            }
            else{
                if(successString.equals("Success")){
                    Intent intent = new Intent (MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        }else
        {
            Toast toast = Toast.makeText(MainActivity.this, "No Connection to Retrieve Data.", Toast.LENGTH_LONG);
            toast.show();
        }

}