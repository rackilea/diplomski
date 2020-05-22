private static int SR_CODE = 123;


/**
     * Initializes the speech recognizer and starts listening to the user input
     */
    private void listen()  {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        //Specify language
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.SIMPLIFIED_CHINESE)
        // Specify language model
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        // Specify how many results to receive
        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 5);
        // Start listening
        startActivityForResult(intent, SR_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SR_CODE && resultCode == RESULT_OK)  {
                if(data!=null) {
                //Retrieves the best list SR result
                ArrayList<String> nBestList = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
               String bestResult = nBestList.get(0);
               Toast.makeText(getApplicationContext(), bestResult, Toast.LENGTH_LONG).show;              
            }else {         
                //Reports error in recognition error in log
                Log.e(LOGTAG, "Recognition was not successful");
            }

    }