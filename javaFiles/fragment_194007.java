public CostumRunType(final RunTypeRegistry runTypeRegistry, final 
PluginDescriptor pluginDescriptor) {
    myPluginDescriptor = pluginDescriptor;
    runTypeRegistry.registerRunType(this);
}

@Override
public String getEditRunnerParamsJspFilePath() {
  return myPluginDescriptor.getPluginResourcesPath("editRunParams.jsp");
}

@Override
public String getViewRunnerParamsJspFilePath() {
  return myPluginDescriptor.getPluginResourcesPath("viewRunParams.jsp");
}