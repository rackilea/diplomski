class TextClassifyCnnComparator implements Comparator<Item> {

    private final Item citem;
    private final boolean isAsc;
    private final ECNN encodedFromCNN;

    private Map<Item, Double> scores = new HashMap<>();

    public TextClassifyCnnComparator(Item citem) {
        this(citem, true);
    }

    public TextClassifyCnnComparator(Item citem, boolean isAsc) {
        this.citem = citem;
        this.isAsc = isAsc;
        encodedFromCNN = citem.getEncodedFromCNN();
    }

    private double calcSimilarScore(Item item) {
        Double cached = scores.get(item);
        if (cached != null) {
            return cached;
        }
        double score = item.getEncodedFromCNN().dotProduct(encodedFromCNN);
        scores.put(Item, score);
        return score;
    }

    @Override
    public int compare(Item o1, Item o2) {
        if (isAsc) {
            return calcSimilarScore(o1).compareTo(calcSimilarScore(o2));
        }
        return calcSimilarScore(o2).compareTo(calcSimilarScore(o1));
    }

}