$ AWS_PROFILE=prod aws s3api head-object --bucket example-bucket --key example-directory/
{
    "AcceptRanges": "bytes",
    "LastModified": "Mon, 29 Apr 2019 14:59:36 GMT",
    "ContentLength": 0,
    "ETag": "\"d41d8cd98f00b204e9800998ecf8427e\"",
    "ContentType": "application/x-directory",
    "ServerSideEncryption": "AES256",
    "Metadata": {}
}