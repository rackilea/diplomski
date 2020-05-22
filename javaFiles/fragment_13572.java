Grib2Input input = new Grib2Input(getRandomAccessFile());
if (!input.scan(false, false)) {
    logger.error("Failed to successfully scan grib file");
    return;
}
Grib2Data data = new Grib2Data(getRandomAccessFile());

List<Grib2Record> records = input.getRecords();

for (Grib2Record record : records) {    
    Grib2IndicatorSection is = record.getIs();
    Grib2IdentificationSection id = record.getId();
    Grib2Pds pdsv = record.getPDS().getPdsVars();
    Grib2GDSVariables gdsv = record.getGDS().getGdsVars();

    long time = id.getRefTime() + (record.getPDS().getForecastTime() * 3600000);

    logger.debug("Record description at " + pdsv.getReferenceDate() + " forecast "
    + new Date(time)    + ": " + ParameterTable.getParameterName(is.getDiscipline(), pdsv.getParameterCategory(), pdsv.getParameterNumber()));

    float[] values = data.getData(record.getGdsOffset(), record.getPdsOffset(), 0);

     if ((is.getDiscipline() == 0) && (pdsv.getParameterCategory() == 2) && (pdsv.getParameterNumber() == 2)) {
        // U-component_of_wind
        int c = 0;
        for (double lat = gdsv.getLa1(); lat >= gdsv.getLa2(); lat = lat - gdsv.getDy()) {
            for (double lon = gdsv.getLo1(); lon <= gdsv.getLo2(); lon = lon + gdsv.getDx()) {
                logger.debug(lat + "\t" + lon + "\t" +
                values[c]);
                c++;
            }
        }
    } else if ((is.getDiscipline() == 0) && (pdsv.getParameterCategory() == 2) && (pdsv.getParameterNumber() == 3)) {
        // V-component_of_wind
        int c = 0;
        for (double lat = gdsv.getLa1(); lat >= gdsv.getLa2(); lat = lat - gdsv.getDy()) {
            for (double lon = gdsv.getLo1(); lon <= gdsv.getLo2(); lon = lon + gdsv.getDx()) {
                logger.debug(lat + "\t" + lon + "\t" +
                values[c]);
                c++;
            }
        }
    }
}