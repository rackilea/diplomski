public class BucketOfAandB {
    private List<Long> aIds;
    private List<Long> bIds;
    public void addAId(Long id) {
        if (aIds == null) {
            aIds = new ArrayList<>();
        }
        aIds.add(id);
    }
    public void addBId(Long id) {
        if (bIds == null) {
            bIds = new ArrayList<>();
        }
        bIds.add(id);
    }
}