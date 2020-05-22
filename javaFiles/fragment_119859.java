public static String WebElementXPath(WebElement element) {
    if (element.tagName.toUpperCase() == 'HTML')    return '/html';
    if (element.tagName.toUpperCase() == 'BODY')      return '/html/body';


    // calculate position among siblings
    int position = 0;
    // Gets all siblings of that element.
    List<WebElement> siblings = WebUI.executeJavaScript("return arguments[0].parentNode.childNodes", [element])
    WebElement innerSibs
    //List<WebElement> siblings = element.parentNode.childNodes;

    WebElement sibling
    def type,response
    for(int i=0;i<siblings.size();i++){
        type = WebUI.executeJavaScript("return arguments[0].nodeType", [siblings[i]])
        if (type == null){
            continue;
        }
        if(type!=1){
            continue;
        }
        sibling = siblings[i];
        // Check Siblink with our element if match then recursively call for its parent element.
        if (sibling == element) {
            innerSibs = WebUI.executeJavaScript("return arguments[0].parentElement", Arrays.asList(sibling))
            if(innerSibs==null){
                return ""
            }
            response = functions.WebElementXPath(innerSibs)
            return response+'/'+element.tagName+'['+(position+1)+']';

        }

        // if it is a siblink & element-node then only increments position.
        type = WebUI.executeJavaScript("return arguments[0].nodeType", [sibling])
        if (type == 1 && sibling.tagName == element.tagName)            position++;

    }
}