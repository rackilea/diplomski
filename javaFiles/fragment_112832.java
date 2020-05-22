List<Integer> list = new ArrayList<>();

try (BufferedReader input = new BufferedReader(new FileReader("file.txt"))) {
    String temp = "";
    while ((temp = input.readLine()) != null) {
        if (!temp.trim().equals("0")) {
            list.add(new Integer(temp));
        }
    }
} catch (IOException e) {
    e.printStackTrace();
}

// you can use list here, knock yourself out