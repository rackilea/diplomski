private void setNewsReleaseDate(Page page, int month) throws InvalidDateException{
    LOGGER.info("change prop at page path "+page.getPath());
    Resource res = rr.getResource(page.getPath()+"/jcr:content");
    String date = "2014-%sT11:31:00.000-04:00"; //07-23
    Calendar rd = DateUtil.parseISO8601(String.format(date, "0"+month+"-23")); //iso8601Date        
    ModifiableValueMap modMap = res.adaptTo(ModifiableValueMap.class);
    if (modMap != null) {
        modMap.put("releaseDate", rd); // this is a Date property
        modMap.put("notes", "hello"); // a string property  
    }
}