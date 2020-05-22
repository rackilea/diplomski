final CMAUpload upload =
client
    .uploads()
    .create("<space_id>",
        // this stream should point to your file to be uploaded.
        new FileInputStream("your file")
    );