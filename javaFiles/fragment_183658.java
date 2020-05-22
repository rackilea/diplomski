File file = new File("data.bin");
if (file.exists()) {
    ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
    try {
        Map<String, Set<Integer>> read = (Map<String, Set<Integer>>) in.readObject();
        for (String key : read.keySet()) {
            System.out.print(key + ": ");
            Set<Integer> values = read.get(key);
            for (Integer value : values) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    } finally {
        in.close();
    }
}