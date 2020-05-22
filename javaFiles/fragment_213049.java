List<String> credentials = new ArrayList<>();
// Populate this list with all of your credentials

BufferedReader bReader = new BufferedReader(new FileReader(textFile));
boolean foundCredentials = false;

String line;
while ((line = bReader.readLine()) != null) {
    // Set your condition to analyze the line and find the credentials you are looking for
    if (credentials.contains(line)) {
        foundCredentials = true;
        break;
    }
}
bReader.close();

if (foundCredentials) {
    // Proceed to next frame
}