public static void main(String[] args) {
        int i=0;
        System.out.println("start");
        ObjectListing listing = s3Client.listObjects( "emr-logs");
        System.out.println("Listing size "+listing.getObjectSummaries().size());
        System.out.println("At 0 index "+ listing.getObjectSummaries().get(0).getKey());
        System.out.println("At 999 index "+ listing.getObjectSummaries().get(999).getKey());
        while (listing.isTruncated()) {
            if(i>3)break;
            System.out.println("========================================================================");
            listing = s3Client.listNextBatchOfObjects(listing);
            System.out.println("Listing size "+listing.getObjectSummaries().size());
            System.out.println("At 0 index "+ listing.getObjectSummaries().get(0).getKey());
            System.out.println("At 999 index "+ listing.getObjectSummaries().get(999).getKey());
            i++;
        }
        System.out.println("end");
    }