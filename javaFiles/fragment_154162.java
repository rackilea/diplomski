List<String> list1 = new ArrayList<>();
    List<String> list2 = new ArrayList<>();
    String line;
    for (int i = 0; (line = br.readLine()) != null; i++) {
        if (i % 2 == 0) {
            list1.add(line);
        } else {
            list2.add(line);
        }
    }
    String[] even = list1.toArray(new String[list1.size()]);
    String[] odd = list2.toArray(new String[list2.size()]);