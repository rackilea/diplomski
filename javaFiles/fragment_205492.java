class MyJSON {
    ArrayList<Header> header;
    ArrayList<Summary> summary;
    ArrayList<Detail> detail;
}

class Header {
    String document_number;
    String report;
    String version;
}
// create classes for Summary and Detail as well in the similar way of Header
// the variable name must be same as it is in JSON string along with case.

...

// read JSON from the file
StringBuilder builder = new StringBuilder();
BufferedReader reader = new BufferedReader(new FileReader(new File("resources/json1.txt")));
String line = null;
while ((line = reader.readLine()) != null) {
    builder.append(line);
}
reader.close();

// create a new Gson object
Gson gson = new Gson();
// convert JSON string to POJO object
MyJSON object = gson.fromJson(builder.toString(), MyJSON.class);

// printing only header
for (Header header : object.header) {
    System.out.println(header.document_number + ", " + header.report + ", "
            + header.version);
}