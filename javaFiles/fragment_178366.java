public class ImageLoader extends AsyncTask <Void, Void, Bitmap>{

private String URL;
private int type;
private Context context;
private InputStream in;

ImageLoader(Context context, String Url, int Type)
{
    URL = Url;
    type = Type;
    ImageLoader.this.context = context;
}

@Override
protected void onPreExecute()
{
   AssetManager assetMgr = context.getAssets();

   try {

       in = assetMgr.open(URL);
   } catch (IOException e) {

       e.printStackTrace();
   }

}

@Override
protected Bitmap doInBackground(Void... arg0) {

    Bitmap bitmap = null;
    try {
        bitmap = BitmapFactory.decodeStream(in);
        in.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return bitmap;
}

@Override
protected void onPostExecute( Bitmap result )  {

      if (type == 1)
          Inst1 = result;
      else if (type == 2)
          Inst2 = result;
      else if (type == 3)
          Inst3 = result;
}
}