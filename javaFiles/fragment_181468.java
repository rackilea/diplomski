Publishing a Photo (see Graph API documentation)

// Publishing an image to a photo album is easy
// Just specify the image you'd like to upload and RestFB will handle it from there.

FacebookType publishPhotoResponse = facebookClient.publish("me/photos", FacebookType.class,
  BinaryAttachment.with("cat.png", getClass().getResourceAsStream("/cat.png")),
  Parameter.with("message", "Test cat"));

out.println("Published photo ID: " + publishPhotoResponse.getId());

// Publishing a video works the same way as uploading a photo.

facebookClient.publish("me/videos", FacebookType.class,
  BinaryAttachment.with("cat.mov", getClass().getResourceAsStream("/cat.mov")),
  Parameter.with("message", "Test cat"));