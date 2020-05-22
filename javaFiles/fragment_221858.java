File sourceFile = findFile(Environment.getExternalStorageDirectory(),"x.apk");
            if (sourceFile==null){
                Toast.makeText(getApplicationContext(), 
                        "Couldn't find x.apk file in your SD card",
                        Toast.LENGTH_LONG).show();
                break;
            }