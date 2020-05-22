<cfscript>
manager = createObject("java", "javax.script.ScriptEngineManager").init();
jsEngine = manager.getEngineByName("js");

showdownJS = fileRead('#getDirectoryFromPath(getCurrentTemplatePath())#/showdown.js');

jsEngine.eval(showdownJS);
showdownConverter = jsEngine.eval("new Showdown.converter()");

markdownString = fileRead("#getDirectoryFromPath(getCurrentTemplatePath())#/markdown.txt");

args = [markdownString];

result = jsEngine.invokeMethod(
    showdownConverter,
    "makeHtml",
    args
) & "";
</cfscript>