StringBuilder stringBuilder = new StringBuilder();
InputStream inputStream = getResources().openRawResource(R.raw.your_text_file);
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
String line;

try {
    while ((line = bufferedReader.readLine()) != null) {
        stringBuilder.append(line).append("\n");
    }

    bufferedReader.close();

} catch (IOException ioe) {
    ioe.printStackTrace();
}

TextView textView = (TextView) findViewById(R.id.your_text_view);
textView.setText(stringBuilder.toString());