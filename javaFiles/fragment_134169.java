// Create URL object
URL url = new URL(singleUrl);
BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

File downloadedFile = new File(DOWNLOAD_FOLDER+generateFilename()+".html");

BufferedWriter writer = new BufferedWriter(new FileWriter(downloadedFile));

// read each line from stream till end
String line;
while ((line = reader.readLine()) != null) {
    writer.write(line);
}

reader.close();
writer.close();