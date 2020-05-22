mOrderButton.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
        String textFromInput = mQuantityEditText.getText().toString();
        String supplierText  = mSupplierEditText.getText().toString();
        if(!textFromInput.isEmpty() && !supplierText.isEmpty()){
            int i =Integer.parseInt(textFromInput);
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:" + supplierText));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Product Order");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "I would like to order "+String.valueOf(i));
            try {
                 startActivity(Intent.createChooser(emailIntent, "Send email using..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(EditProductActivity.this, "No email clients installed.", Toast.LENGTH_SHORT).show();
            }
        }else{
            //The textfield is empty, do something about it...
        }
     }
});