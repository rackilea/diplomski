PDDocument document1 = ...;
...
PDDocument documentN = ...;

PdfVeryDenseMergeTool tool = new PdfVeryDenseMergeTool(PDRectangle.A4, 30, 30, 10);
tool.merge(new FileOutputStream(RESULT_FILE), Arrays.asList(document1, ..., documentN));