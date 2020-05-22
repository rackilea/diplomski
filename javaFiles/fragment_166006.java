ScriptObjectMirror jsDate = (ScriptObjectMirror) engine.eval("new Date();")
long timestampLocalTime = (long) (double) jsDate.callMember("getTime"); 
// yes, js date returns timestamp in local time so you need to adjust it... ;)
int timezoneOffsetMinutes = (int) (double) jsDate.callMember("getTimezoneOffset");
// java.util.Date construcctor utilizes UTC timestamp
Date jDate = new Date(timestampLocalTime + timezoneOffsetMinutes * 60 * 1000);