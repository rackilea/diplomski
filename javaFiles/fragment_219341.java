underContent.saveState();
underContent.setGState(gs);
underContent.beginText();
underContent.setFontAndSize(bf, fontSize);
underContent.setColorFill(Color.LIGHT_GRAY);
underContent.endText();
underContent.addImage(image, image_width, 0, 0, image_height, x_co_ordinate , y_co_ordinate );
underContent.restoreState();