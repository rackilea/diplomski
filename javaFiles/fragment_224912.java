InputStream in = null;
try {
        in = new ByteArrayInputStream(csvData);

        List lines = IOUtils.readLines(in, "UTF-8");
        Iterator it = lines.iterator();
        String line = "";
        while (it.hasNext()) {
        line = (String) it.next();

        String description = null;
        String code = null;
        String[] columns = line.split(";");

        if (columns.length >= 2) {
            code = columns[0];
            String[] dest = new String[columns.length - 1];
            System.arraycopy(columns, 1, dest, 0, columns.length - 1);
            description = org.apache.commons.lang.StringUtils.join(dest, ";");
          (...)