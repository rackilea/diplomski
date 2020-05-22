If you want to use custom layout, use **Dialog** instead of **AlertDialog** :

 public void Qdialog()
{
     Dialog dialog = new Dialog(this)
     dialog.setContentView(R.layout.dialoglayouttest);
     dialog.setTitle("Title...");
     TextView text = (TextView) dialog.findViewById(R.id.dia_tit);
     dialog.show();
}