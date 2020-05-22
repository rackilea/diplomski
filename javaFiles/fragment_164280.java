greyed = new Image(e.display, image, SWT.IMAGE_GRAY);

e.gc.drawImage(greyed,
    0, 0, w, h,
    0, 0, scaledWidth, scaledHeight
);