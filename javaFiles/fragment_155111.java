protected void checkIfPageExists(HttpServletRequest req)
throws     ServletException {

String relativeUrl = requestUrlToTemplatePath(req);
try {
        getConfiguration().getTemplate(relativeUrl); //throws exception if the template cannot be accessed
    } catch (TemplateNotFoundException e) {
        logger.debug("TemplateNotFoundException for " + relativeUrl);
        pageNotFound = "/customNotFoundPage.html";
    } catch (IOException e) {
        logger.debug("IOException for " + relativeUrl);
        pageNotFound = "/customNotFoundPage.html";
    } 
  req.setAttribute(NOT_FOUND_PAGE, pageNotFoundPage);
}