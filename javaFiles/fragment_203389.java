if (success == 1) {
   // successfully created product
   Intent i = new Intent(getApplicationContext(), AllProductsActivity.class);
   startActivity(i);

   // closing this screen
   pDialog.dismiss(); // <------- add this line
   finish();
}