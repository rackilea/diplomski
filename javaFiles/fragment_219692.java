HashMap tmplParams=new HashMap();

tmplParams.put("__resourceBundle",ResourceBundle.getBundle(
    "<parent directory path>.activities.resources.nls.notification"));

root.put("__parameters",tmplParams);