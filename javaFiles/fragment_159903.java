filenamearray = filenamefinal.split(";");
    try {


        List<String> results = new ArrayList<String>();
        for (int i = 0; i < filenamearray.length; i++) {

            File txt = new File(getExternalFilesDir(Environment.DIRECTORY_MUSIC) + "/" + filenamearray[i] + ".txt");
            if (txt.exists()) {

                txtread = new FileInputStream(getExternalFilesDir(Environment.DIRECTORY_MUSIC) + "/" + filenamearray[i] + ".txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(txtread));
                String text = reader.readLine();
                displaytxt = text.substring(0, 45) + ". . ."
                results.add(displaytxt);
            } else {
                results.add("empty");
            }
        }

        finalversetextarray = new String[results.size()];
        finalversetextarray = results.toArray(finalversetextarray);