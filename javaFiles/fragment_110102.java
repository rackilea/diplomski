private Date getLastModified(ClientResponse response){
    String lastModifiedString = response.getHeaders().getFirst(
            "Last-Modified");
    if (StringUtils.isEmpty(lastModifiedString)) {
        LOG.warn("Expect to get Last-Modified header when retrieving a Person by pnr "
                + "but there is none.");
        return null;
    } else {
        try {
            // format is Thu, 21 Jun 2012 08:00:42 GMT
            return new SimpleDateFormat(
                    "EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US)
                    .parse(lastModifiedString);
        } catch (ParseException e) {
            LOG.error("Could not parse Last-Modified date "
                    + e.getMessage());
            return null;
        }
    }
}