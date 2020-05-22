AssetDescriptor<Texture> assetDescriptor=new AssetDescriptor<Texture>("brick.png",Texture.class);

AssetManager assetManager=new AssetManager();
assetManager.load(assetDescriptor);   // load by assetDescriptor
assetManager.load("badlogic.jpg", Texture.class);   // manual loading

assetManager.finishLoading();

texture=assetManager.get("badlogic.jpg",Texture.class);  // fetch data manually 
texture1=assetManager.get(assetDescriptor);              // fetch by descriptor