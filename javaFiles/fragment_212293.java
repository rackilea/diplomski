public static ArrayList<String> arrayListConstructor(String filename) throws IOException {
    ArrayList<String> list = new ArrayList<String>();
    try (BufferedReader br = new BufferedReader(new FileReader(filename));) {
        for (String line; (line = br.readLine()) != null) {
            list.add(line);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return list;
}


public static void main(String[] args) {

    ArrayList<String> hosts = arrayListConstructor("e:\\\\hosts.lst");
    ArrayList<String> users = arrayListConstructor("e:\\\\users.lst");
    JSONArray arr = new JSONArray();

    for (int counter = 0, counter2 = 0; counter < hosts.size() && users.size() >= 2; counter++, counter2++) {
        String hostname = hosts.get(counter);
        String username = users.get(counter2);
        if (counter2 == 1) {
            counter2 = 0;
        }

        JSONObject obj = new JSONObject();

        obj.put("hostname", hostname);
        obj.put("username", username);
        arr.put(obj);

        System.out.print(obj);
        System.out.println("\n");

    }
    System.out.print(arr);
}