try {
    if(txtweb.getText().toString().equals("Google Plus")) {
            setContentView(R.layout.google);
     InputStream is = getAssets().open("read_asset.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String text = new String(buffer);
            TextView tv = (TextView)findViewById(R.id.text);
            tv.setText(text);
        } else if(txtweb.getText().toString().equals("Twitter")){
            setContentView(R.layout.google);
        }
    } catch (IOException e) {
            throw new RuntimeException(e);
        }