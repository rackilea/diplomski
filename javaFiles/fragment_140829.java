class ReportCreator {
  public File createSomeImportantReport(LocalDate date) {
    String fileName = provideFileName(date);
    File result = new File(fileName);
    return result;
  }

  private String provideFileName(LocalDate date) {
    // ... some complex business logic to generate file name based on date... ;)

    return fileName;
  }
}