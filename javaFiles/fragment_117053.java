class TweetStatusWritable implements Writable {
    private String keywords;
    private List<Status> tweets;
    private long queryTime;

    // add getters for the above three fields

    public void readFields(DataInput in) {
        this.keywords = in.readUTF();
        int size = in.readInt();
        this.tweets = new List<Status>();
        for(int i = 0; i < size; i++) {
            Status status = // deserialize an instance of Status
            tweets.add(status);
        }
        this.queryTime = in.readLong();
    }

    public void write(DataOutput out) {
        out.writeUTF(this.keywords);
        out.writeInt(this.tweets.size());
        for(int i = 0; i < this.tweets.size(); i++) {
             // serialize tweets[i] onto out
        }       
        out.writeLong(queryTime);
    }

    public TweetStatusWritable(
        String keywords,
        List<Status> tweets,
        long queryTime
    ) {
        this.keywords = keywords;
        this.tweets = tweets;
        this.queryTime = queryTime;
    }
}