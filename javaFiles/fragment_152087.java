@Override
public void onClick(View v) {
if(v.getItemId() == R.id.button1){
//do what you want here:
startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/external/images/media/16"))) //As deeper answered to open the gallery
}