try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
    final List<List<String>> table = br.lines()
            .map(row -> Stream.of(row.split(","))
                    .collect(Collectors.toList()))
            .collect(Collectors.toList());

    System.out.println(table.get(0));
} catch (IOException e) {
    e.printStackTrace();
}