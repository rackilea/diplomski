public class Writer {
    private Map<String, Integer> myHashMap;

    public Writer() {
        myHashMap = new HashMap<>();

        myHashMap.put("a", 1);
        myHashMap.put("b", 2);
        myHashMap.put("c", 3);
    }


    public void doStuff() {
        try {
            // Create new file
            final String path = "myCreatedTxt.txt";
            File file = new File(path);

            // If file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);


            myHashMap.entrySet().forEach(x -> {
                try {
                    bw.write(x.getKey() + " ");
                } catch (IOException e) {
                    System.out.println("error accord");
                }
            });

            // Close connection
            bw.close();
        } catch (IOException x) {
            System.out.println(x);
        }
    }
}