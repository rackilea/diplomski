byte[] myImage = ...;
NdefRecord myImageRecord = new NdefRecord(
        NdefRecord.TNF_MIME_MEDIA,
        "image/jpeg".getBytes("US-ASCII"),
        null,
        myImage
);