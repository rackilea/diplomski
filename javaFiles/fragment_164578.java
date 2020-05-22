public class Demo {

    public static void main(String[] args) throws IOException {
        Map<String, String> descMap = new HashMap<>();
        String line;
        // read all item descriptions
        try (BufferedReader br1 = new BufferedReader(new FileReader("item_desc.csv"))) {
            while ((line = br1.readLine()) != null) {
                int itemNbrSeparator = line.indexOf(',');
                String itemNbr = line.substring(0, itemNbrSeparator);
                descMap.put(itemNbr, line);
            }
        }
        List<String> matched = new ArrayList<>();
        // read the item numbers and store each matched
        try (BufferedReader br = new BufferedReader(new FileReader("item_no.csv"))) {
            while ((line = br.readLine()) != null) {
                if (descMap.containsKey(line)) {
                    System.out.println(descMap.get(line));
                    matched.add(descMap.get(line));
                }
            }
        }
        // output all matched
        Path outFile = Paths.get("item_match.csv");
        Files.write(outFile, matched, Charset.defaultCharset(), new LinkOption[0]);
    }
}