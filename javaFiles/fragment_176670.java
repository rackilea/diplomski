workbook = WorkbookFactory.create(new File(absoluteFilePath));

....

FileOutputStream fileOutputStream = new FileOutputStream(
                new File(absoluteFilePath));
workbook.write(fileOutputStream);