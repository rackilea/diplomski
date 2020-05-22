NSURL imgUrl = new NSURL(EXTERNAL_IMG_URL);
NSData data = NSData.read(imgUrl); 
UIImage image = new UIImage(data); 
NSString appStoreUrl = new NSString(APP_STORE_URL); 
NSString googleUrl = new NSString(GOOGLE_PLAY_URL); 
NSString text = new NSString(TEXT_TO_SHARE); 
NSArray<NSObject> texttoshare = new NSArray<NSObject>(text, image, appStoreUrl, googleUrl); 
UIActivityViewController share = new UIActivityViewController( 
texttoshare, null); 
if (UIDevice.getCurrentDevice().getUserInterfaceIdiom() == UIUserInterfaceIdiom.Phone) {  

 //iPhone 
iosApplication.getUIViewController().presentViewController( 
 share, true, null);  
} else { 
 //iPad 

 UIPopoverController popover = new UIPopoverController(share);
 UIView view = iosApplication.getUIViewController().getView(); 
 CGRect rect = new CGRect( 
 view.getFrame().getWidth() / 2, 
 view.getFrame().getHeight() / 4, 
 0, 
 0); 
 popover.presentFromRectInView( rect, view, UIPopoverArrowDirection.Any, true); 
 }