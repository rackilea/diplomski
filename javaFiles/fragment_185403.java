String javaScript = "var callback = arguments[0];"+
            "function defer() {if (window.jQuery.masonry){ "+
            "callback(true) }else{ callback(false) }}; defer()";

boolean isMasonryLoaded=false;
while(!isMasonryLoaded)
{
 isMasonryLoaded = (boolean)(((JavascriptExecutor)driver).executeAsyncScript(javaScript));
}