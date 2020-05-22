private void runScript(String javaScriptCode,String functionNameInJavaScriptCode,Object[] params) {
    org.mozilla.javascript.Context rhino = org.mozilla.javascript.Context.enter();
    rhino.setOptimizationLevel(-1);
    try {
        Scriptable scope = rhino.initStandardObjects();

        rhino.evaluateString(scope,javaScriptCode , "JavaScript", 1, null);

        // Get the functionName defined in JavaScriptCode
        Object obj = scope.get(functionNameInJavaScriptCode, scope);

        if (obj instanceof org.mozilla.javascript.Function) {
            org.mozilla.javascript.Function jsFunc = (org.mozilla.javascript.Function) obj;


            // Call the function with params
            Object jsResult =
                    jsFunc.call(rhino, scope, scope, params);
            // Parse the jsResult object to a String
            String result = org.mozilla.javascript.Context.toString(jsResult);
            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    finally {
        org.mozilla.javascript.Context.exit();
    }

}