public static int editTextNumber = 0;


public void openScanner1 (View view) {
IntentIntegrator scanIntegrator = new IntentIntegrator (this);
scanIntegrator.initiateScan();
editTextNumber  = 1;
}


public void openScanner2 (View view) {
IntentIntegrator scanIntegrator = new IntentIntegrator(this);
scanIntegrator.initiateScan();
editTextNumber = 2;
}