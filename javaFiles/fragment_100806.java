Scanner scan = new Scanner(new File(jsonFile));
    String jsonData = "";
    while (scan.hasNext()) {
        jsonData += scan.nextLine();// + "\n";
    }
    scan.close();

    JSONObject json = new JSONObject(jsonData);

    String xml = org.json.XML.toString(json);

    System.out.println(xml);