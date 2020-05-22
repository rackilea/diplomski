public void exportSubjectData(File outputFile, String subNum, String sensorType) throws IOException, SQLException {

    csvWrite = new CSVWriter(new FileWriter(outputFile));

    String arrStr[] = null;

    switch (sensorType) {
        case "acc": {
            curCSV = db.rawQuery("SELECT * FROM " + DATA_ACC_TABLE_NAME + " WHERE id = " + subNum, null);
            arrStr = new String[] {curCSV.getString(0), curCSV.getString(1), curCSV.getString(2),
                    curCSV.getString(3), curCSV.getString(4)};
            break;
        }
        case "gyro": {
            curCSV = db.rawQuery("SELECT * FROM " + DATA_GYRO_TABLE_NAME + " WHERE id = " + subNum, null);
            arrStr = new String[] {curCSV.getString(0), curCSV.getString(1), curCSV.getString(2)};
            break;
        }
    }

    csvWrite.writeNext(curCSV.getColumnNames());

    while (curCSV.moveToNext()) {
        csvWrite.writeNext(arrStr);
    }

    csvWrite.close();
    curCSV.close();
}