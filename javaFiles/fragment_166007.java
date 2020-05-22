public interface JsDateWrapper {
    long getTime();
    int getTimezoneOffset();
    // ...
}

Object jso = engine.eval("new Date();");
JsDateWrap jsDate = ((Invocable) engine).getInterface(jso, JsDateWrapper.class);
Date jDate = new Date(jsDate.getTime() + jsDate.getTimezoneOffset() * 60 * 1000);