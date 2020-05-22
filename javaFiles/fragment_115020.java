@PostConstruct
private void initDatabase(){

  authorRepository.deleteAll();

  Author dv = new Author();
  dv.setFirstName("Dan");
  dv.setLastName("Vega");
  dv.setEmail("danvega@gmail.com");
  authorRepository.save( dv );

  postRepository.deleteAll();

  Post post = new Post();
  post.setTitle("Spring Data Rocks!");
  post.setSlug("spring-data-rocks");
  post.setTeaser("Post Teaser");
  post.setBody("Post Body");
  post.setPostedOn(new Date());
  post.setAuthor(dv);
  postRepository.save(post);

  // add the code below
  dv.posts = new ArrayList<Post>();
  dv.posts.add(post);
  authorRepository.save( dv );

}