public class MainActivity extends AppCompatActivity {

    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonNext = (Button) findViewById(R.id.btnNext);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "NextClicked", Toast.LENGTH_SHORT).show();
                //checkBarcode("123");
                String getBarcode = scanBarcodeEditText.getText().toString().trim();

                if (TextUtils.isEmpty(getBarcode)) {
                    scanBarcodeEditText.setError("Please enter barcode");
                } else {
                    checkBarcode(getBarcode);
                }
            }
        });
    }


    private void checkBarcode(final String barcode) {

        //Toast.makeText(MainActivity.this, "Method Call", Toast.LENGTH_SHORT).show();

        collectionReference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot queryDocumentSnapshot : task.getResult()) {
                        if (queryDocumentSnapshot.getString("barCode") != null) {
                            collectionReference.document(queryDocumentSnapshot.getId()).update("productQuantity", FieldValue.increment(1).toString());
                            // Intent to another activity
                        } else {
                            // Intent to another activity
                        }
                    }
                }
            }
        });
    }
}