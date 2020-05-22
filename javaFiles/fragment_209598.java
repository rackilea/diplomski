Display display = composite.getDisplay();
Rectangle rect = composite.getClientArea();
Image i = new Image(display, composite.getClientArea().width, composite.getClientArea().height);
GC gc = new GC(i);

composite.print(gc);            // This is important

ImageLoader loader = new ImageLoader();
loader.data = new ImageData[]{i.getImageData()};
loader.save("hello.png", SWT.IMAGE_PNG);

gc.dispose();
i.dispose();