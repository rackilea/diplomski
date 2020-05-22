StringBuilder csv = new StringBuilder();

        Cursor cursor = this.db.query("Data", new String[] { "x","y", "z", "t" }, null, null, null, null, null);

        while (cursor.moveToNext()) {
            csv.append(cursor.getFloat(0))
            .append(",")
            .append(cursor.getFloat(1))
            .append(",")
            .append(cursor.getFloat(2))
            .append(",")
            .append(cursor.getFloat(3))
            .append("\n");
        }

cursor.close();

        File outputFile = new File("/sdcard/mycsv.csv");

        FileWriter writer;
        try {
            writer = new FileWriter(outputFile);

            writer.write(csv.toString());

            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }