public void display(String ticker) {
    System.out.printf("Portfolio #%s", ticker);
    for (Map.Entry<String, Double> entry : priceMap.entrySet()) {
        System.out.printf(", %s = " + "%.2f", entry.getKey(), entry.getValue());
    }
    System.out.println();   // finish up the line.
}