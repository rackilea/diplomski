@Data
    public  static class Holiday{
        private String name;
        private Set<GiftSet> giftSets;
    }

    @Data
    public static class  GiftSet {
        private Integer id;
        private Holiday holiday;
    }