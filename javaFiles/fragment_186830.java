final Dialog dialog = new Dialog(context);
dialog.setContentView(R.layout.info_dialog);
dialog.setTitle(episode);
TextView descrip = (TextView) dialog.findViewById(R.id.dialog_text); //change in this line
descrip.setText(descript);
dialog.show();