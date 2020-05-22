protected void onPostExecute(String file_url) {

String fileName = editText.getText().toString();
        String keyName = editText2.getText().toString();

        File sdcard = Environment.getExternalStorageDirectory();
        File file = new File(sdcard , fileName);
        File key  = new File(sdcard, keyName);

BufferedReader brFile;
    String Cipher = null;
    try{
        //Read file line by line and concat each line of string in file with space character.
        FileInputStream fstream = new FileInputStream(file);
        brFile = new BufferedReader(new InputStreamReader(fstream));

        String tempString;

        while((tempString = brFile.readLine()) != null){

            if(Cipher == null){
                Cipher = tempString;

            }else{
                Cipher = Cipher.concat(" ");
                Cipher = Cipher.concat(tempString);

            }

        }

    }catch(Exception e){
        //messageBox("Decrypt", e.getMessage());
    }

    BufferedReader brKey;
    String DecKey = null;

    try{
        FileInputStream fstream = new FileInputStream(key);
        brKey = new BufferedReader(new InputStreamReader(fstream));
        DecKey = brKey.readLine();

    }catch(Exception e){
        //messageBox("Decrypt", e.getMessage());
    }


    try{
        byte[] cipherByte = DES.parseBytes(Cipher);
        String decKey = DES.convertStringToHex(DecKey);

        byte[] keyByte = DES.parseBytes(decKey);
        String decryptResult = DES.hex(DES.decryptCBC(cipherByte, keyByte));

        String temp = decryptResult.replace(" ", "");
        String finalDecrypt = temp.substring(0, (temp.length() - DES.getConcatCount()));
        String finResult = DES.convertHexToString(finalDecrypt);

        TextView FinalResult = (TextView)findViewById(R.id.decryptText);
        FinalResult.setText(finResult);

    }catch(Exception e){
        messageBox("Decrypt", "Please Upload File Properly");
    }
}

Since it's work fine, I try to implement this method with Async Task for running my work in background. The class that implemented shown below:

private class runDecrypt extends AsyncTask <URL , Integer, Long> {
     private final ProgressDialog dialog = new ProgressDialog(Homepage.this);
     AlertDialog.Builder builder = new AlertDialog.Builder(Homepage.this);
    @SuppressWarnings("resource")
    @Override
    protected Long doInBackground(URL... params) {
        EditText editText = (EditText) findViewById(R.id.fileName);
        EditText editText2 = (EditText) findViewById(R.id.keyName);

        String fileName = editText.getText().toString();
        String keyName = editText2.getText().toString();

        File sdcard = Environment.getExternalStorageDirectory();
        File file = new File(sdcard , fileName);
        File key  = new File(sdcard, keyName);


        BufferedReader brFile;
        String Cipher = null;
        try{
            //Read file line by line and concat each line of string in file with space character.
            FileInputStream fstream = new FileInputStream(file);
            brFile = new BufferedReader(new InputStreamReader(fstream));

            String tempString;

            try {
                while((tempString = brFile.readLine()) != null){

                    if(Cipher == null){
                        Cipher = tempString;

                    }else{
                        Cipher = Cipher.concat(" ");
                        Cipher = Cipher.concat(tempString);

                    }

                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }catch(java.io.FileNotFoundException e){
            System.out.println("File could not be found.");
        }

        BufferedReader brKey;
        String DecKey = null;
        try{
            FileInputStream fstream = new FileInputStream(key);
            brKey = new BufferedReader(new InputStreamReader(fstream));
            try {
                DecKey = brKey.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }catch(java.io.FileNotFoundException e){
            System.out.println("Key file could not be found.");
        }

        String decKey = DES.convertStringToHex(DecKey);     
        byte[] cipherByte = DES.parseBytes(Cipher);
        byte[] keyByte = DES.parseBytes(decKey);
        String decryptResult = DES.hex(DES.decryptCBC(cipherByte, keyByte));

        String temp = decryptResult.replace(" ", "");
        String finalDecrypt = temp.substring(0, (temp.length() - DES.getConcatCount()));
        String finResult = DES.convertHexToString(finalDecrypt);

        TextView FinalResult = (TextView)findViewById(R.id.decryptText);
        FinalResult.setText(finResult);
}
}