try (final BufferedReader br = Files.newBufferedReader(new File("stock.txt").toPath(),
            StandardCharsets.UTF_8)) {
        List<StockRecord> stocks = new ArrayList<StockRecord>();
                    br.readLine() ; // to avoid first line
        for (String line; (line = br.readLine()) != null;) { // first step
            final String[] data = line.split(",");       // second step
            StockRecord record = new StockRecord(data[0], Double.valueOf(data[1]));
            stocks.add(record);    // third step
        }
    } catch (IOException e) {
        e.printStackTrace();
    }