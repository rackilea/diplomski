Set<Integer> dataset = new HashSet<>();
    dataset.add(8);
    dataset.add(3);
    dataset.add(7);
    try (FileWriter fw = new FileWriter("\\Users\\Test.txt", true); // true -> append
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {
        out.println(dataset);
    } catch (IOException e) {
        System.err.println("An exception occured: " + e.getMessage());
    }