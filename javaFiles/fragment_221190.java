// On PostsContentsEntity class:

@OneToOne(optional=false)
@JoinColumn(
    name="POST_ID", unique=true, nullable=false, updatable=false)
public PostsEntity getPostsEntity() { return postsEntity; }

// On PostsEntity class:

@OneToOne(optional=false, mappedBy="postsEntity")
public PostsContentsEntity getPostsContentsEntity() { return postsContentsEntity; }