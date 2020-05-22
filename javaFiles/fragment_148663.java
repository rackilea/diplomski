JSONObject jsonObject = makeJsonObject();
    try{
        Writer output = null;
        File file = new File(Environment.getExternalStorageDirectory(), "importantemail.json");
        if(file.isDirectory()){
            file.delete();
        }
        if(!file.exists()){
            file.createNewFile();
        }
        output = new BufferedWriter(new FileWriter(file));
        output.write(jsonObject.toString());
        output.close();
        Toast.makeText(getApplicationContext(), "Composition saved", Toast.LENGTH_LONG).show();

    } catch (Exception e) {
        Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
    }
    finish();


}
public JSONObject makeJsonObject()
{
    JSONObject object = new JSONObject();
    try {
        object.put("Message ID", 5);
        object.put("Sender","test");
        object.put("Subject","test");
        object.put("E-mail:","test");
    }catch (JSONException e)
    {
        e.printStackTrace();
    }
    return object;
}