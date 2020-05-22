public String articleTextToJson(String article, String title, String sourceUrl) {
    if (null == article) {
        return "{ \"error\" : { " +
               "       \"message\" : \"Article did not extract\", " +
               "       \"code\" : 1 " +
               "    }, " +
               "  \"status\" : \"error\" " +
               "}";
    }
    return "{ \"response\" : { " +
           "       \"title\" : \"" + title + "\" " +
           "       \"content\" : \"" + article + "\", " +
           "       \"source\" : \"" + sourceUrl + "\" " +
           "    }, " +
           "  \"status\" : \"success\" " +
           "}"
}