Calendar currentDate = Calendar.getInstance();
SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MMM_dd");
String dateNow = formatter.format(currentDate.getTime());

String fileName = ("Table_export_"+ dateNow + ".xls");

response.setContentType("application/vnd.ms-excel");
response.setHeader("Content-Disposition","attachment;filename="+fileName);

OutputStream outputStream = response.getOutputStream();
try {
    wb.write(outputStream);
} finally {
    outputStream.close();
}