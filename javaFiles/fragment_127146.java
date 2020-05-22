window.onunload = function() {
    if (closingWindow){
        document.getElementById('logoutLink').click();
        windows.setTimeout(doNothingFunction,2000);
    }
}