public static void export2CSV(HttpServletResponse response,
        String[] header, String filePrefix, List<? extends Object> dataObjs) {
    ICsvBeanWriter writer;
    try{
        response.setContentType("text/csv;charset=utf-8"); 
        response.setHeader("Content-Disposition",
            "attachment; filename="+filePrefix+"_Data.csv");

        OutputStreamWriter outputwriter = 
            new OutputStreamWriter(response.getOutputStream()); 

        writer = new CsvBeanWriter(outputwriter, CsvPreference.EXCEL_PREFERENCE);

        // the actual writing
        writer.writeHeader(header);

        for(Object anObj : dataObjs){
            writer.write(anObj, header);                                
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            writer.close(); // closes writer and underlying stream
        } catch (Exception e){}
    }
};