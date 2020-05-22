//out.write(...filedata...); // <------ How to Put file data in output stream ?

// Create a path to your file
Path path = Paths.get("D:/TEMP/bulk.json"); // <------ your file name

// Open a BufferedReader to your file - change CharSet if necessary
BufferedReader fReader = Files.newBufferedReader(path, Charset.defaultCharset());

String data = null;
// Read each line, append "\n" to it as required by Bulk API and write it to the server
while ((data = fReader.readLine()) != null) {
    out.write(data + "\n"); // <------ Put each line in output stream
    out.flush();            // <------ You may do this outside the loop once
}

out.close();