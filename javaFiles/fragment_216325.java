public static void fillArrayList(String fileName) throws FileNotFoundException {
    List<String> list = new ArrayList<String>();
    File file = new File(fileName);
    if (file.exists()) {
        try {
            list = Files.readAllLines(file.toPath(), Charset.defaultCharset());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (list.isEmpty())
            return;
    }

    for (String line : list.subList(1, list.size())) {
        System.out.println(line);

        String[] res = line.split(",");
        String[] arr = res[1].split(" ");

        List<Integer> emotions = new ArrayList<Integer>();
        emotions.add(Integer.parseInt(res[0]));
        Emotions.add(emotions);

        List<Integer> pixels = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            pixels.add(Integer.parseInt(arr[i]));
        }
        Pixels.add(pixels);
    }
}