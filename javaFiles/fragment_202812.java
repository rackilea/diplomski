byte[] logoIconInBytes = loadImage(LOGO_ICON_PATH, "png");
InputStreamSource logoImageSource = new ByteArrayResource(logoIconInBytes);
message.addInline(LOGO_IMAGE_RESOURCE, logoImageSource, IMAGE_CONTENT_TYPE);
byte[] phoneIconInBytes = loadImage(PHONE_ICON_PATH, "png");
InputStreamSource phoneImageSource = new ByteArrayResource(phoneIconInBytes);
message.addInline(PHONE_IMAGE_RESOURCE, phoneImageSource, IMAGE_CONTENT_TYPE);
byte[] emailIconInBytes = loadImage(EMAIL_ICON_PATH, "png");
InputStreamSource emailImageSource = new ByteArrayResource(emailIconInBytes);
message.addInline(EMAIL_IMAGE_RESOURCE, emailImageSource, IMAGE_CONTENT_TYPE);