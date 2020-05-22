final Pattern p = Pattern.compile(".*_(\\d{4})-(\\d{2})\\.pdf$");

for (File obj : contentsOfDirectory) {
  if (obj.isFile()) 
    String file = "this is the file directory";
    String pdfBills = file + obj.getName().toString();

    Matcher m = p.matcher(pdfBills);
    if (m.matches()) {
      int year = Integer.parseInt(m.group(1));
      int month = Integer.parseInt(m.group(2));
      // ... do stuff with year and month
    }