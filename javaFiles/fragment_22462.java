// set the loaders for the generator and the fonts themselves
FileHandleResolver resolver = new InternalFileHandleResolver();
manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));

// load to fonts via the generator (implicitely done by the FreetypeFontLoader).
// Note: you MUST specify a FreetypeFontGenerator defining the ttf font file name and the size
// of the font to be generated. 
FreeTypeFontLoaderParameter size1Params = new FreeTypeFontLoaderParameter();            
size1Params.fontFileName = "ls-bold.otf";//name of file on disk
size1Params.fontParameters.size = ((int)((Gdx.graphics.getWidth()*0.10f)));         
manager.load("fontWinFail.ttf", BitmapFont.class, size1Params);//BUGGY:We need to append .ttf otherwise wont work...just put any name here and append .ttf MANDATORY(this is the trick)