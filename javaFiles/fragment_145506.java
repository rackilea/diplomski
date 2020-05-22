copyFiletoExternalStorage(R.raw.yardik_denizi, "yardik_denizi.mp3");
            Uri path= FileProvider.getUriForFile(sansar.this, 
"com.example.tunch.trap", new File(Environment.getExternalStorageDirectory() + 
"/Android/data/yardik_denizi.mp3"));
            Intent shareYardik = new Intent();
            shareYardik.setAction(Intent.ACTION_SEND);
            shareYardik.putExtra(Intent.EXTRA_TEXT,"Bu ses dosyasını gönderiyorum");
            shareYardik.putExtra(Intent.EXTRA_STREAM, path);
            shareYardik.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            shareYardik.setType("audio/mp3");
            startActivity(Intent.createChooser(shareYardik, "Paylas.."));