public void hideElements()
{

String jscode = "var elements = document.getElementsByClassName('className');
    for (var i = 0; i < elements.length; i++){
        elements[i].style.display = 'none';
    };";   

// escaping single / double quotes / tabs / line breaks / so on
jscode =  escapeJS(jscode);   

    ((JavascriptExecutor)driver).executeScript(jscode);
}