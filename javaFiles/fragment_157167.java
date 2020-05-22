DefaultCategoryDataset dataset= new DefaultCategoryDataset();
  // Get today as a Calendar.... 
  Calendar today = Calendar.getInstance();

 for(int i=0; i<15 ;i++)
  {  
   //get util.Date class object for today date.....
   java.util.Date today_date=new java.util.Date(today.getTimeInMillis());

   //convert date in string format to display on chart.....
    String today_string_date = new SimpleDateFormat("dd/MM/yy").format(today_date);

    // set values to DefaultCategoryDataset to display on chart...
    dataset.setValue(rs1.getInt("login_count"),"Login Frequency", today_string_date);
    today.add(Calendar.DATE, -1);

  }// for closing...

JFreeChart chart = ChartFactory.createBarChart3D("ISIS:Overall login history for last 15 days", "Date -->", "No  of  user(s)  login  per  day -->", dataset, PlotOrientation.VERTICAL, true, true, false);

 CategoryPlot p = chart.getCategoryPlot(); 
 NumberAxis rangeAxis = (NumberAxis) p.getRangeAxis();

 rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
 BarRenderer renderer = (BarRenderer) p.getRenderer();
 DecimalFormat decimalformat1 = new DecimalFormat("##");
 renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", decimalformat1));
 renderer.setItemLabelsVisible(true);

ChartUtilities.saveChartAsPNG(new File(filePath +"/chart1.png"), chart ,1250, 400);