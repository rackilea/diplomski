String Barcode = data.getValue().toString();
if (Barcode.equals(rawResult.getText())){
String ProductName = dataSnapshot.child("ProductName").getValue().toString();
AlertDialog.Builder builder = new AlertDialog.Builder(BarcodeScannerActivity.this);
                    builder.setTitle("Scan Result");
                    builder.setMessage(ProductName);
                    AlertDialog alert1 = builder.create();
                    alert1.show();
}