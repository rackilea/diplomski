try {
        FileOutputStream fos = openFileOutput("file.mp3", Context.MODE_PRIVATE);
        fos.write(...) // etc
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }