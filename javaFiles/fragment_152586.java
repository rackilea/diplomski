private static String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(new Date());
  String reportLocation = "C:/ReportFolder/" + "Testing " + fileName + ".html";

  static ExtentReports getInstance() {
    if (extent == null) {
        extent = createInstance(reportLocation);
        System.out.println("JUST CREATED A NEW EXTENT");
    }