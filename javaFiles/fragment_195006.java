public static class SkuDataVO implements Serializable {

    public String skuTitle;

    public String headline;

    @JsonUnwrapped // <-- magic happens here
    public SubmissionSku submissionSku;

    public SkuDataVO(SubmissionSku submissionSku, String title, String headline) {
        this.submissionSku = submissionSku;
        this.skuTitle = title;
        this.headline = headline;
    }
}