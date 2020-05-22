@Column(name = "blog_id", length = 36)
public UUID blog_id;

@ManyToOne
@JoinColumn(name = "blogId")
public Blog blog;