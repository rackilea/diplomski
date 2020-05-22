ObjectListing listing = s3.listObjects( bucketName, prefix );
doSomeProcessing(listing);

while (listing.isTruncated()) {
   listing = s3.listNextBatchOfObjects (listing);
   doSomeProcessing(listing);
}