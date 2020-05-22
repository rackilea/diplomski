public class ElementsFileReader {

    public static List<Element> read(String filePath) throws IOException {
        FileReader fileReader = new FileReader(new File(filePath));

        BufferedReader br = new BufferedReader(fileReader);

        List<Element> elements = new ArrayList<>();
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] lineParts = line.split(",");
            int atomicNumber = Integer.parseInt(lineParts[0]);
            double atomicMass = Double.parseDouble(lineParts[1]);
            String atomicSymbol = lineParts[2];
            String atomicName = lineParts[3];

            elements.add(new Element(atomicNumber, atomicMass, atomicSymbol, atomicName));
        }
        return elements;
    }
}