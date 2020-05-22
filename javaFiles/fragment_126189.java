String Barcode = data.child("Barcode").getValue(String.class);
if (Barcode.equals(rawResult.getText())){
String ProductName = data.child("ProductName").getValue(String.class);
AlertDialog.Builder builder = new AlertDialog.Builder(BarcodeScannerActivity.this);
                    builder.setTitle("Scan Result");
                    builder.setMessage(ProductName);
                    AlertDialog alert1 = builder.create();
                    alert1.show();
}