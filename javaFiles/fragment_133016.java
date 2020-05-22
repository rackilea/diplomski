FileWriter writer = null;
try {
    writer = new FileWriter("C:\\fileName.json");
    gson.toJson(obj, writer);
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (writer != null) {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}