String adminSecret = "API-ADMIN-SECRET";
Integer partnerId = PARTNER_ID;
String filePath = "src/DemoVideo.flv";
String uploadUserId = "TestUploader";

// initialize the client
KalturaConfiguration config = new KalturaConfiguration();
config.setEndpoint("http://www.kaltura.com/");
KalturaClient client = new KalturaClient(config);
String ks = client.generateSession(adminSecret, uploadUserId, KalturaSessionType.ADMIN, partnerId);
client.setKs(ks);

// add the media entry
KalturaMediaEntry mediaEntry = new KalturaMediaEntry();
mediaEntry.name = "Uploaded Media";
mediaEntry.mediaType = KalturaMediaType.VIDEO;
mediaEntry = client.getMediaService().add(mediaEntry);

// add the upload token
KalturaUploadToken uploadToken = new KalturaUploadToken();
uploadToken = client.getUploadTokenService().add(uploadToken);

// initialize the file
File file = new File(filePath);

// upload the file
client.getUploadTokenService().upload(uploadToken.id, file);

// link between the file and the media entry
KalturaUploadedFileTokenResource uploadedFileTokenResource = new KalturaUploadedFileTokenResource();
uploadedFileTokenResource.token = uploadToken.id;
client.getMediaService().addContent(mediaEntry.id, uploadedFileTokenResource);