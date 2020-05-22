@Override
public void share() {
    NSArray<NSObject> items = new NSArray<>(
            new NSString("Hey! Check out this mad search engine I use"),
            new NSURL("https://www.google.com"),
            new UIImage(Gdx.files.external("image.png").file())
    );
    UIActivityViewController uiActivityViewController = new UIActivityViewController(items, null);
    ((IOSApplication) Gdx.app).getUIViewController().presentViewController(uiActivityViewController, true, null);
}