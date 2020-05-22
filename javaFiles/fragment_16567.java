List<String> lines = Files.readLines("YourFilePath", Charsets.UTF_8);
    lines.forEach(System.out::println);
    lines.forEach(s -> {
        String[] rows = s.split(",");
        int[][] array2D = new int[rows.length][];
        for (int i = 0; i < rows.length ; i++) {
            String[] column = rows[i].trim().replace("{", "").replace("}", "").split(" ");
            int[] ints = new int[column.length];
            for (int j = 0; j < column.length; j++) {
                ints[j] = Integer.parseInt(column[j]);
            }
            array2D[i] = ints;
        }
        System.out.println(Arrays.deepToString(array2D));
    });