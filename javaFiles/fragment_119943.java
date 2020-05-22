String toc = "";
    int summary = 0;
    try {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Class.forName(JDBC_DRIVER);

        con = DriverManager.getConnection(DB_URL, USER, PASS);

        String query = "Select toc as TypeOfCall,Sum(toc) as SummaryOfCalls from processeddata_table group by toc";

        ps = con.prepareStatement(query);
        rs = ps.executeQuery();
        while (rs.next()) {
            toc = rs.getString("TypeOfCall");
            summary = rs.getInt("SummaryOfCalls");
            dataset.setValue(summary, toc, toc);
        }
        JFreeChart chart = ChartFactory.createBarChart("Call cost", "TypeOfCall", "SummaryOfCalls", dataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p = chart.getCategoryPlot();

         //p.setRangeGridlinePaint(Color.BLUE);

        ChartPanel panel = new ChartPanel(chart);
        panel.setVisible(true);
        panel.setSize(200, 200);
        display_graph.add(panel);

    } catch (ClassNotFoundException | SQLException e) {

    }