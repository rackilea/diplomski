byte[] logoIconInBytes = loadImage(LOGO_ICON_PATH, "png");
InputStreamSource logoImageSource = new ByteArrayResource(logoIconInBytes);
message.addInline(LOGO_IMAGE_RESOURCE, logoImageSource, IMAGE_CONTENT_TYPE);
byte[] phoneIconInBytes = loadImage(PHONE_ICON_PATH, "png");
InputStreamSource phoneImageSource = new ByteArrayResource(phoneIconInBytes);
message.addInline(PHONE_IMAGE_RESOURCE, phoneImageSource, IMAGE_CONTENT_TYPE);
byte[] emailIconInBytes = loadImage(EMAIL_ICON_PATH, "png");
InputStreamSource emailImageSource = new ByteArrayResource(emailIconInBytes);
message.addInline(EMAIL_IMAGE_RESOURCE, emailImageSource, IMAGE_CONTENT_TYPE);
// Dummy content that won't be displayed to make all previous icons visible on the email
message.addInline("emptyIcon", new ByteArrayResource(new byte[0]), IMAGE_CONTENT_TYPE);