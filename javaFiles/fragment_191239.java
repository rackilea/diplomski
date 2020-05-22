Resources normalResources = getResources();
AssetManager assets = normalResources.getAssets();
DisplayMetrics metrics = normalResources.getDisplayMetrics();
Configuration config = new Configuration(standardResources.getConfiguration());
config.locale = Locale.FRENCH;
Resources frenchResources = new Resources(assets, metrics, config);

String s = defaultResources.getString(R.string.hello); // s: "Bonjour"