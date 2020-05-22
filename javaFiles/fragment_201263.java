File file = new File(PATH_TO_TXT);
    ArrayList<Integer> storage = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] arr = line.split("\t");
            storage.add(Integer.valueOf(arr[2].trim()));
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    Map<Integer, Long> occurrences = storage.stream()
     .collect(Collectors.groupingBy(e -> e, Collectors.counting()));