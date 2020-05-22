List<Composite> listComposites=new ArrayList<Composite>();

Composite aPaste = ImagesServiceFactory.makeComposite(aImage, 0, 0, 1f, Composite.Anchor.TOP_LEFT);
listComposites.add( aPaste );

Composite bPaste = ImagesServiceFactory.makeComposite(bImage, 300, 0, 1f, Composite.Anchor.TOP_LEFT);
listComposites.add( bPaste );

Image newImage = imagesService.composite(listComposites, 600, 300, 0xff333333L, ImagesService.OutputEncoding.JPEG);