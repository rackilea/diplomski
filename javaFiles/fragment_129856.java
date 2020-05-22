public StockData(String symbol, String start, String end) {

    String url = "https://quotes.wsj.com/fx/AEDUSD/historical-prices/download?MOD_VIEW=page&num_rows=300&startDate="+start+"+&endDate="+end;

    try {
        URL rowdata = new URL(url);
        URLConnection data = rowdata.openConnection();
        Scanner input = new Scanner(data.getInputStream());
        if (input.hasNext()) // remove
            input.nextLine();  //remove

        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.println(line);
        }
    }
    catch (Exception e) {
        System.out.print(e);
    }
}