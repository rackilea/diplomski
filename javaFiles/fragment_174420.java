public static void main(String[] args) throws IOException {

    String csvFile = "file path";
    String line;
    String cvsSplitBy = ",";
    String netPrice;
    String tax;
    BigDecimal finalTotal = BigDecimal.ZERO;

    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] Amount = line.split(cvsSplitBy);

            netPrice = Amount[11]; //hold 12th column value
            netPrice = netPrice.replace("\"", "");
            BigDecimal netPriceBd = new BigDecimal(netPrice);

            tax = Amount[12]; //hold 13th column value
            tax = tax.replace("\"", "");
            BigDecimal taxBd = new BigDecimal(tax);

            BigDecimal total = netPriceBd.add(taxBd);

            finalTotal = finalTotal.add(total);
        }

    } catch (NumberFormatException n) {
        n.printStackTrace();
    }
}