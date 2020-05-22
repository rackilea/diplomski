StringBuilder result = new StringBuilder();
    String inputLine = "";
    while ((inputLine = in.readLine()) != null) {
        result.append(inputLine);
    }
    fOut = openFileOutput("notes", MODE_PRIVATE);
    fOut.write(result.toString().getBytes());