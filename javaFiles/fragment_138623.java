try {
    InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader buf = new BufferedReader(reader);
    while (true) {
        map.printMap();
        if(!reader.ready()) {
            Thread.sleep(1000);
            continue;
        }
        String command = buf.readLine();
        System.out.println("Command: " + command);
    }
} catch(Exception e ){ 
    e.printStackTrace();
}