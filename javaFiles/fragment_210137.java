in onCreate():
...
alfabetBike();
...
public static void alfabetBike() {
    for (int i = 0; i < tips.length(); i++) {
        String[] derbasi_arr = sernavs[i];
        String[] derbasi_got = gotins[i];
        for (int j = 0; j < hejmar[i] - 1; j++) {
            int indeks = j;
            String yaMezin = derbasi_arr[j];
            for (int k = j + 1; k < hejmar[i]; k++) {
                if (compareTwoString(yaMezin.substring(1), derbasi_arr[k].substring(1)) > 1) {
                    yaMezin = derbasi_arr[k];
                    indeks = k;
                }
            }
            if (indeks != j) {
                derbasi_arr[indeks] = derbasi_arr[j];
                String derbasi = derbasi_got[indeks];
                derbasi_got[indeks] = derbasi_got[j];
                derbasi_arr[j] = yaMezin;
                derbasi_got[j] = derbasi;
            }
        }
        gotins[i] = derbasi_got;
        sernavs[i] = derbasi_arr;
    }
}

private static void printFile(){
    alfabetBike();
    File root = android.os.Environment.getExternalStorageDirectory();
    File dir = new File (root.getAbsolutePath() + "/alfabetfolder");
    dir.mkdirs();
    File file = new File(dir, "alfabet_title.txt");
    File file2 = new File(dir, "alfabet.txt");

    try {
        FileOutputStream f = new FileOutputStream(file,false);
        PrintWriter pw = new PrintWriter(f);
        FileOutputStream f2 = new FileOutputStream(file2,false);
        PrintWriter pw2 = new PrintWriter(f2);

        for (int i = 0; i < tips.length(); i++) {
            for (int j = 0; j < hejmar[i]; j++) {
                Log.d("ssdddddd", "add" + hejmar[i] + "-" + j + "  " + sernavs[i][j].trim());
                pw.println(sernavs[i][j]);
                pw.flush();
                pw2.println(sernavs[i][j]  + "\n" + gotins[i][j].trim());
                pw2.flush();
            }
        }
        pw.close();
        f.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
        Log.i("erroooor", "******* File not found. Did you" +
                " add a WRITE_EXTERNAL_STORAGE permission to the   manifest?");
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static int compareTwoString(String yek, String du) {
    String d1 = yek, d2 = du;
    d1 = strLower(d1, d1.charAt(0));
    d2 = strLower(d2, d2.charAt(0));
    int length, yaDirej;

    if (yek.length() > du.length()) {
        yaDirej = 1;
        length = yek.length();
    } else if (yek.length() < du.length()) {
        yaDirej = 2;
        length = du.length();
    } else {
        yaDirej = 0;
        length = yek.length();
    }

    for (int i = 0; i < length; i++) {
        int id1 = -1, id2 = -1;
        if (i == d1.length() || i == du.length()) {
            return yaDirej;
        }
        for (int j = 0; j < tips.length(); j++) {
            if (d1.charAt(i) == tips.charAt(j)) id1 = j;
            if (d2.charAt(i) == tips.charAt(j)) id2 = j;
        }
        if (id1 > id2)
            return 2;
        else if (id2 > id1)
            return 1;
        else
            continue;
    }
    return 0;
}

public static String strLower(String str, char ziman){
    final StringBuilder mutable = new StringBuilder(str);
    final StringBuilder yedek = new StringBuilder(str.toLowerCase());
    for (int i = 0; i < str.length(); i++) {
        if (ziman == '?' && mutable.charAt(i) == 'I')
            mutable.setCharAt(i, 'i');
        else if (ziman == '*' && mutable.charAt(i) == 'I')
            mutable.setCharAt(i, 'ı');
        else mutable.setCharAt(i,yedek.charAt(i));
    }
    return mutable.toString();
}