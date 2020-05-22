private void updateLastEmailTimeStamp(String jsonFilePath) {
    JSONParser parser = new JSONParser();
    JSONObject jsonObject = new JSONObject();

    FileReader reader =null;
    try {
        File jsonFile = new File(jsonFilePath);
        reader = new FileReader(jsonFile);
        jsonObject = (JSONObject) parser.parse(reader);

        jsonObject.remove("lastEmailSent");


        //write current date as last mail sent time.
        writeTimeStamp(jsonObject, jsonFile);

        APP_LOGGER.info("last Email Sent timestamp updated");       
    } catch (IOException ex) {
        APP_LOGGER.error(ex.getLocalizedMessage(), ex);
    } catch (ParseException ex) {
        APP_LOGGER.error(ex.getLocalizedMessage(), ex);
    } catch (RuntimeException e) {
        e.printStackTrace();
    }catch (Exception e) {
        e.printStackTrace();
    }

}


/**
 * Method to write current date as last mail sent timestamp 
 * denoting when the newsletter was sent last.
 * 
 * @param jsonObj- date for last email sent.
 * @param jsonFile - recentactivities.json file
 */
@SuppressWarnings("unchecked")
private void writeTimeStamp(JSONObject jsonObj, File jsonFile) {
    FileWriter writer = null;
    try {
        writer = new FileWriter(jsonFile);

        String currentDate = MyDateFormatter.formatDate(new Date(),"dd/MM/yyyy HH:mm");

        jsonObj.put("lastEmailSent", currentDate);


        writer.write(jsonObj.toJSONString());
    }catch(IOException ex){
        APP_LOGGER.error(ex.getLocalizedMessage(), ex);
    }finally{
        try {
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            APP_LOGGER.error(ex.getLocalizedMessage(), ex);
        }
    }
}