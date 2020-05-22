List<Integer> x_values = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader("x.csv"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split("\n");
            List<Integer> intValues = Arrays.asList(values).stream()
                    .map(Double::parseDouble) // parse x.xxE+02 to xxx.0
                    .map(Double::intValue) // xxx.0 to integer xxx
                    .collect(Collectors.toList()); // back to List
            x_values.addAll(intValues);
        }

    } catch (IOException e) {
        e.printStackTrace();
    }