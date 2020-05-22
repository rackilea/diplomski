public int buttonPressed; // ADD A VARIABLE TO STORE VALUE

    public void cardOneClicked(View view){
            Toast.makeText(getApplicationContext(),
                    "Card one Clicked with ID: " + Integer.toString(cardOneID), Toast.LENGTH_SHORT).show();
            IntentIntegrator integrator = new IntentIntegrator(activity);
            integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
            integrator.setPrompt("Scan 1");
            integrator.setCameraId(0);
            integrator.setBeepEnabled(true);
            integrator.setBarcodeImageEnabled(true);
            integrator.setOrientationLocked(false);
            integrator.initiateScan();

            buttonPressed = 1;    // SET PRESSED BUTTON 1
        }


        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {

            Log.d("BUTTON_TEST", "Pressed button ID is " + buttonPressed);  // SHOW BUTTON

            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

            if (result != null){
                if(result.getContents() == null){
                    Toast.makeText(this, "You Cancelled Scan", Toast.LENGTH_SHORT).show();
                }
                else{
                    result.getOrientation();

                    Toast.makeText(this, result.getContents(), Toast.LENGTH_SHORT).show();
                }
            }
            else{
                super.onActivityResult(requestCode, resultCode, data);
            }
        }