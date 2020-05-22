public void initializeChipsViewholdersArray (){
   for (int i = 1; i<10; i ++){
        String viewholderName = "chip_00"+i;
       int id_2 = R.id.class.getField(viewholderName).getInt(0);
   ImageView chipViewholder= (ImageView)findViewById(id);
           chipViewholder.setVisibility(View.INVISIBLE);
}