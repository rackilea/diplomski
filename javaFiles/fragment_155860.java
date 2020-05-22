ArrayList<String> myFile = new ArrayList<String>;

File[] listFile = directory.listFiles();

for (int i = 0; i < listFile.length; i++) {

    if (listFile[i].isDirectory()) {
        walkdir(listFile[i]);
    } else {
        if (listFile[i].getName().endsWith(fileType)) {
            myFile.add(listFile[i].getName().toString());
        }
    }

}

adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, myFile);

songList.setAdapter(adapter);