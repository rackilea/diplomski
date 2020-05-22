class Story{
  int idStory;
  User idUser;
  @OneToMany(fetch = FetchType.Lazy)
  List<Comment> comments;
}