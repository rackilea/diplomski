BufferedReader reader = new BufferedReader(new FileReader(new File("pathname")));
        String line = null;
        Map<String, Integer> map = new HashMap<String, Integer>();// it should be static - whereever you define
        while ((line = reader.readLine()) != null) {
            if (line.contains("=")) {
                String[] strings = line.split("=");
                map.put(strings[0], Integer.parseInt(strings[1]));
            }
        }