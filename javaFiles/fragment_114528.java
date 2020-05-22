@OneToMany(cascade = CascadeType.PERSIST)
@JoinTable(name = "tweet_likes") //<--CREATES SEPERATE TABLE
private final List<Account> likedBy = new ArrayList<>();
@OneToMany(cascade = CascadeType.PERSIST)
@JoinTable(name = "tweet_mentions") //<--CREATES SEPERATE TABLE
private final List<Account> mentions = new ArrayList<>();