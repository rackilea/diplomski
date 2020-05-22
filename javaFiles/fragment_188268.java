public void Qdialog()
 {
     LayoutInflater inflater = this.getLayoutInflater();
     View dialogView = inflater.inflate(R.layout.dialoglayouttest, null);
     quotesbuilder = new AlertDialog.Builder(Menuslection.this);
     quotesbuilder.setView(dialogView);   
     EditText editText = (EditText) dialogView.findViewById(R.id.dia_tit);
     quotesalert = quotesbuilder.create();
     quotesalert.show();
 }