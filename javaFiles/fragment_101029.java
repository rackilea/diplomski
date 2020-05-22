public static void main(String args[]) throws Exception {

            {
                File file = new File("jsonFormatting.json");
                if (!file.exists()) {
                    System.out.println("No file");
                } else {
                    try {
                        JSONParser parser = new JSONParser();
                        Object obj = parser.parse(new FileReader("jsonFormatting.json"));
                        JSONObject jsonObject = (JSONObject) obj;
                        JSONArray jsonItemInfo = (JSONArray) jsonObject.get("itemInfo");

                        JSONObject newObject = new JSONObject();

                        newObject.put("item", new Integer(10003));
                        newObject.put("name", "ID10003");

                        StringWriter out = new StringWriter();
                        newObject.writeJSONString(out);
                        String jsonText = out.toString();
                        System.out.println(jsonText);

                        jsonItemInfo.add(newObject);
                        jsonObject.put("itemInfo", jsonItemInfo);
                        FileWriter fileToWrite = new FileWriter("jsonFormatting.json", false);
                        try {
                            fileToWrite.write(jsonObject.toJSONString());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        fileToWrite.flush();
                        fileToWrite.close();

                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }