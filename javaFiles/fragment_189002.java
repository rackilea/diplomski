public void showMyDialog(){

dialog=new Dialog(ExperiencesActivity.this);
ViewHolder viewholder;
                dialog.setContentView(R.layout.exp1);
                dialog.setCancelable(true);
                dialog.setTitle("My Experiences");

                ViewHolder.textview1 = (TextView)dialog.findViewById(R.id.tv11);
                ViewHolder.textview1.setText("Title:" + expname);
                ViewHolder.textview2 = (TextView)dialog.findViewById(R.id.tv22);
                ViewHolder.textview2.setText("Content:" + expcontent);
                ViewHolder.button23=(Button)dialog.findViewById(R.id.btnSubmit);
               ViewHolder.button23.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();

                    }
                });
 dialog.show();
}