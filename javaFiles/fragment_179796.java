// Let's assume the "desired output" you acquired 
// is contained within a Text file named "HtmlData.txt".

// Hold our scraped data in a 2D List inteface.
List<List<String>> list = new ArrayList<>();

// Read File using BufferedReader in a Try With Resources block...
try (BufferedReader reader = new BufferedReader(new FileReader("HtmlData.txt"))) {
    String line;
    List<String> numbers = null;
    while ((line = reader.readLine()) != null) {
        numbers = new ArrayList<>();
        line = line.trim();
        if (line.equals("")) {
            continue;
        }
        if (line.startsWith("onclick=\"doWindow(this.href,")) {
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.endsWith("return")) {
                    list.add(numbers);
                    break;
                }
                if (line.equals("")) {
                    continue;
                }
                if (line.startsWith("<td align=\"right\" class=\"nowrap\">")) {
                    numbers.add(getBetween(line, "<td align=\"right\" class=\"nowrap\">", "</td>", true, true)[0]);
                }
            }
        }
        if (line.contains("name=\"productData[price]")) {
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.equals("")) {
                    continue;
                }
                if (line.startsWith("[{33013477}]")) {
                    numbers.add("Product Price: " + getBetween(line, "value=\"", "\">", true, true)[0]);
                    list.add(numbers);
                    break;  // DONE
                }
            }
        }
    }
    if (numbers != null && !numbers.isEmpty()) {
        list.add(numbers);
    }
}
catch (IOException ex) {
    ex.printStackTrace();
}

// Display our findings to the Console Window in a 
// table style format:
for (int i = 0; i < list.size(); i++) {
    for (int j = 0; j < list.get(i).size(); j++) {
        System.out.printf("%-10s ", list.get(i).get(j));
    }
    System.out.println("");
}