String response = "";

try {
    FileInputStream fis = getActivity().openFileInput("personal_profile");
    DataInputStream isr = new DataInputStream(fis);
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(isr));
    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = bufferedReader.readLine()) != null) {
        sb.append(line);
    }
    line = response;

} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}