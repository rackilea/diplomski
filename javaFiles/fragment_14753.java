private void writeReportFile(String fileName,StringBuffer reportContent){
        FileWriter myFileWriter = null;
        try {
            myFileWriter = new FileWriter(fileName);
            myFileWriter.write(reportContent.toString());
        }
        catch (IOException e) {

        }
        finally {
            if (myFileWriter!=null) {
                try {
                    myFileWriter.close();
                }
                catch (IOException e) {

                }
            }
        }
    }