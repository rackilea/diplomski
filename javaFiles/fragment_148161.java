String input = "...";
try (StringReader sr = new StringReader(input); BufferedReader in = new BufferedReader(sr)) {
    String line;
    while ((line = in.readLine()) != null) {
        JSONObject object = new JSONObject(line);
        System.out.println(object.get("created_at"));
    }
} catch (IOException e) {
    // this should not happen but let's log it anyway
    e.printStackTrace();
}