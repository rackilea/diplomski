@Override
protected String doInBackground(String... arg0) {
    try {
        v=new Validate();
        String result;
        result=v.SendParam(url,user,pass);
        return result;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}