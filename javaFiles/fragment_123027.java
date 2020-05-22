public static void main(String[] args) {
    BufferedReader reader;
    HashMap<String, HashMap<String, String>> hMap = new HashMap<>();
    try {
        reader = new BufferedReader(new FileReader("file.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            if(line.startsWith("[Call ")){
                String callId = line.split(",")[3];
                hMap.put(callId, new HashMap<>());
            }
            else if(line.startsWith("[CallId")){
                String callId = line.substring(line.indexOf('[')+1, line.indexOf(']')).trim();
                hMap.get(callId).put("Agent", line.split(",")[1]);
                hMap.get(callId).put("AgentId", line.split(",")[2]);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    System.out.println(hMap);
}