public BarChartGenerator(org.qcri.power.ws.client.Server oServer, ServerStatistics oServerStat, List lVMs, String path) extends ApplicationFrame {

        System.setProperty("java.awt.headless", "true");
        boolean headless = GraphicsEnvironment.isHeadless();
        System.out.println("Headless: " + headless);
        Toolkit tk = Toolkit.getDefaultToolkit();
        tk.beep();

        // generate dataset
        final CategoryDataset dataset = createDataset(lVMs);
        setChart(createChart(oServer, oServerStat, lVMs, dataset));

        // create PNG of the chart...
        setFilename("chart_server"+oServer.getHost()+"_"+System.currentTimeMillis()+".gif");

        File fImageFile = new File(path+filename);
        try {
            ChartUtilities.saveChartAsPNG(fImageFile, chart, PowerInterface.CHART_WIDTH, PowerInterface.CHART_HEIGHT);
        } catch (Exception e) {
            e.printStackTrace();
        }
   }