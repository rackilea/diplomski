if (!textOverlay) {
  textType = "" 

  // null is considered false, so no need to explicitly check for null
  if (url) {

    // getResourceResolver() replaced by resourceResolver
    // Page and Page.class are the same thing
    Page getPage = resource.resourceResolver.getResource(url).adaptTo(Page)

    // Groovy truth
    if (getPage) {

      // use String concatenation operator (also works in Java)
      showLink += ".html"

      // non-empty strings evaluate to true
      if (fragment) {
          // GString instead of string concatenation
          url += "#$fragment"
      }
    }
  }             
}  else { 
    //do something else
}