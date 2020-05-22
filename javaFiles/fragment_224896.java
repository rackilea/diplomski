BufferedReader br;
    try {
        br = new BufferedReader(new FileReader("d:/temp/r.res"));

        Map<String, List<String[]>> map = new TreeMap<String, List<String[]>>();
        while (br.ready()) {
            String s = br.readLine();
            if (!s.trim().isEmpty()) {
                String[] tokens = s.split(" ");
                List<String[]> values = map.get(tokens[1]);
                if (values == null) {
                    values = new ArrayList<String[]>();
                    map.put(tokens[1], values);
                }
                values.add(new String[]{tokens[0],  tokens[3]});
            }
        }
    } finally {
        br.close();
    }