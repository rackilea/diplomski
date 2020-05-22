File file = new File(Environment.getExternalStorageDirectory()
            .getAbsolutePath() + "/doma/" + fileName);

    String response = "";

    if (file.exists()) {
        Toast.makeText(this, fileName + " exists", Toast.LENGTH_SHORT).show();
        BufferedReader br;

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "cp1252"));
            for (String line; (line = br.readLine()) != null; response += line + '\n') ;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

Toast.makeText(this, "read:\n" + response, Toast.LENGTH_SHORT).show();
                .show();
    } else {
     Toast.makeText(this, "Sorry, " + file + " doesn't exist!!", Toast.LENGTH_LONG)
    }