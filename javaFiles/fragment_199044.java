final Pattern pattern = Pattern.compile("(PDF|XLSX|CVS)");
final Matcher matcher = pattern.matcher("Make the PDF");

if (matcher.find()) {
  setExportType(matcher.group());
}