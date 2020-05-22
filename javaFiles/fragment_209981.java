public void shareGif(String path)
{        
    NSURL url = new NSURL(new File(path));

    NSArray<NSObject> imageArray = new NSArray<NSObject>(image);
    UIActivityViewController share = new UIActivityViewController(imageArray,null);
    ((IOSApplication)Gdx.app).getUIViewController().presentViewController(share, true, null);
}