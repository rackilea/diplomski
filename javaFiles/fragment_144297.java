String[] terms = new String[2];
        Map<String, Integer> map = Arrays.asList(terms).stream()
            .collect(Collectors.toMap(e -> e, e -> Integer.parseInt("0")));
        InputStream is = new FileInputStream(new File(""));
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String lineContent = null;
        while (null != (lineContent = reader.readLine())) {
            String[] words = lineContent.split(" ");
            Arrays.asList(words).stream()
                .forEach(s -> {
                    Integer counts = map.get(s);
                    if (null != counts) {
                        counts++;
                    }
                });
        }