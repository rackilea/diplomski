public class ExcelImporter {
  //...ignore constructor and other methods ...
  public <R> Builder<R> sheet(String sheetName, RowConsumer<R> rowConsumer) {
    return new Builder<R>(sheetName, rowConsumer);
  }

  private static class RowBean {
    private String name;
    private String sex;

    public void setName(String name) {
      this.name = name;
    }

    public void setSex(String sex) {
      this.sex = sex;
    }
  }

  public class Builder<R> {
    public Builder(String sheetName, RowConsumer<R> rowConsumer) {

    }

    //...ignore other method
    public <F> Builder<R> header(String name, CellConsumer<R, F> cellConsumer) {
      return this;
    }

    public <F> Builder<R> header(String name, Class<F> fieldType, CellConsumer<R, String> cellConsumer) {
      return header(name, cellConsumer);
    }

    public ExcelImporter build() {
      return null;
    }
  }

  @FunctionalInterface
  public interface CellConsumer<R, F> {
    void read(F cell, R row);
  }

  @FunctionalInterface
  public interface RowConsumer<R> {
    R newRow();
  }

  public static void main(String[] args) {
    ExcelImporter excelImporter = new ExcelImporter()
        .sheet("Sheet1", () -> new RowBean())
        .header("姓名", String.class, (cell, row) -> row.setName(cell)) // no error
        .header("性别", String.class, (cell, row) -> row.setSex(cell)) // no error!
        .build();
  }
}