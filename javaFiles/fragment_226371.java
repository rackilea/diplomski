public class ValueCount {

    private String userid;
    private int likes;
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }


}
public List<ValueCount> agg(){
    Criteria cr = Criteria.where("userItemStatus").is("1");

    MatchOperation m = match(cr);
    GroupOperation g = group("item_id").count().as("count");
    ProjectionOperation p = project("count").and("item_id").previousOperation();
    SortOperation s = sort(Sort.Direction.DESC,"count");
    LimitOperation limit = limit(20);
    Aggregation agg = newAggregation(m,g,p,s,limit);
    AggregationResults<ValueCount> groupResults = mongoTemplate.aggregate(agg,"user_likedislike",ValueCount.class);
    return groupResults.getMappedResults();
}