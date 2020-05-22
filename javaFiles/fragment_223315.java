mYes.setOnClickListener(new View.OnClickListener() {   
   @Override
   public void onClick(View v) {
        deletePullItem(sheet, item);
        dialog.dismiss();
   }
});