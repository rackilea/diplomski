class ReportCreator {
  private FileNameProvider fileNameProvider;

  public File createSomeImportantReport(LocalDate date) {
    File result = new File(fileNameProvider.provideFileName(date));
    return result;
  }
}

class FileNameProvider {
  public String provideFileName(LocalDate date) {
    return ......;
  }
}