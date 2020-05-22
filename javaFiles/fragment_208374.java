class CloudFrontRetryCondition implements RetryCondition {
    @Override
    public boolean shouldRetry(AmazonWebServiceRequest originalRequest, AmazonClientException exception, int retriesAttempted) {
        if(exception instanceof AmazonS3Exception) {
            final AmazonS3Exception s3Exception = (AmazonS3Exception) exception;
            return  s3Exception.getStatusCode() == 400 &&
                    s3Exception.getErrorCode().equals("MalformedPolicy") &&
                    s3Exception.getErrorMessage().equals("Invalid principal in policy") &&
                s3Exception.getAdditionalDetails().get("Detail").contains("arn:aws:iam::cloudfront:user/CloudFront Origin Access Identity");
        } else {
            return false;
        }
    }
}