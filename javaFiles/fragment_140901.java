List<PluginWrapper> startedPlugins = pluginManager.getStartedPlugins();

    for (PluginWrapper plugin : startedPlugins) {
       String pluginId = plugin.getDescriptor().getPluginId();
       System.out.println(String.format("Extensions added by plugin '%s':", pluginId));
       Set<String> extensionClassNames = pluginManager.getExtensionClassNames(pluginId);
       for (String extension : extensionClassNames) {
           System.out.println("   " + extension);
       }
    }