GenericRawResults<Double> rawResults =
   orderDao.queryRaw(
      "SELECT SUM(productPrice * productQuantity) FROM cart",
      new RawRowMapper<Double>() {
         public Double mapRow(String[] columnNames, String[] resultColumns){
            return Double.parseDouble(resultColumns[0]);
         }
    });