Resources standardResources = context.getResources();
AssetManager assets = standardResources.getAssets();
DisplayMetrics metrics = standardResources.getDisplayMetrics();
Configuration config = new Configuration(standardResources.getConfiguration());
config.locale = yourLocale;
Resources resources = new Resources(assets, metrics, config);