@JoinColumn(name = "author_id")
@ManyToOne(fetch = FetchType.LAZY)
private User author;

public User getAuthor() { return author; }

public void setAuthor(User author) { this.author = author; }