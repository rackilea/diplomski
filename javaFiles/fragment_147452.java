public class TildaDelimiter implements Function<Row, String> {

  public String call(Row r) {
    return r.mkString("~");
  }
}

in my save as i did the following to save as a ~ delimited file

 resultFrame.toJavaRDD().map(new TildaDelimiter()).coalesce(1, true)
            .saveAsTextFile(folderName);