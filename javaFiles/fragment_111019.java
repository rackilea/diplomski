public String searchForBluetoothFolder() {

    String splitchar = "/";
    File root = Environment.getExternalStorageDirectory();
    List<File> btFolder = null;
    String bt = "bluetooth";
    try {
        btFolder = folderSearchBT(root, bt);
    } catch (FileNotFoundException e) {
        Log.e("FILE: ", e.getMessage());
    }

    for (int i = 0; i < btFolder.size(); i++) {

        String g = btFolder.get(i).toString();

        String[] subf = g.split(splitchar);

        String s = subf[subf.length - 1].toUpperCase();

        boolean equals = s.equalsIgnoreCase(bt);

        if (equals)
            return g;
    }
    return null; // not found
}