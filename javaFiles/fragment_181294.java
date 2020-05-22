Map<String, String> data = new HashMap<String, String>();
data.put("a", "value a");
data.put("b", "value b");
data.put("c", "value c");

// Convert a Map to JSON using GSON:
String data = new Gson().toJson(data);

// Write data to the file:
BufferedWriter writer = null;

try {
    writer = new BufferedWriter(new FileWriter("/path/to/file"));
    writer.write(data);
    writer.flush();
} catch ( ... ) {
   ...
} finally {
    if (writer != null) {
        writer.close();
    }
}

// Read the data
$data = json_decode(file_get_contents('/path/to/file'));

print_r($data);