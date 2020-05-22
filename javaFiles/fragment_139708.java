Flux<String> getData(DataSource ds)  {
    return Flux.create(sink -> {
        try {
            Connection con = ds.getConnection();
            con.setAutoCommit(false);
            PreparedStatement stm = con.prepareStatement("SELECT order_number FROM orders WHERE order_date >= '2018-08-12'", ResultSet.TYPE_FORWARD_ONLY);
            stm.setFetchSize(1000);
            ResultSet rs = stm.executeQuery();

            sink.onRequest(batchSize -> {
                try {
                    for (int i = 0; i < batchSize; i++) {
                        if (!rs.next()) {
                            //no more data, close resources!
                            rs.close();
                            stm.close();
                            con.close();
                            sink.complete();
                            break;
                        }
                        sink.next(rs.getString(1));
                    }
                } catch (SQLException e) {
                    //TODO: close resources here
                    sink.error(e);
                }
            });
        }
        catch (SQLException e) {
            //TODO: close resources here
            sink.error(e);
        }
    });
}