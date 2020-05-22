String sitesXML="";
if(sessionObject.get("sitesXmlKey") == null){
sitesXML = (String) sitesService.getSitesForUser(String.class,_emailAddress);
sessionObject.put("sitesXMLKey",sitesXML);
}else{
sitesXML = (String)sessionObject.get("sitesXmlKey");
}