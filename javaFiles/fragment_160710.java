function isAppletActive(app) {
    // assuming `app` is the applet element...
    if(app.status==1) { return false; } // still loading
    if(app.status==2) { throw "Applet load failed"; }

    try { active = app.isActive(); } // IE check 
    catch(ex) { 
        try { active = app.isActive; } // Firefox check 
        catch(ex1) { /* NEVER swallow exceptions! */ } 
    } 
    //alert(active); 
    return active;
}