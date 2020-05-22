from("file://src/data?fileName=file.jpg&noop=true&delay=15m")
    .convertBodyTo(byte[].class)
    .setHeader(S3Constants.CONTENT_LENGTH, simple("${in.header.CamelFileLength}"))
    .setHeader(S3Constants.KEY,simple("${in.header.CamelFileNameOnly}"))
    .to("aws-s3://{{awsS3BucketName}}"
                    + "?deleteAfterWrite=false&region=eu-west-1"
                    + "&accessKey={{awsAccessKey}}"
                    + "&secretKey=RAW({{awsAccessKeySecret}})")
    .log("done.");
}