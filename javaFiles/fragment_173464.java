class User{
  int idUser;
  @OneToMany(fetch = FetchType.EAGER)
  List<Story> stories;
}

class Story{
  int idStory;
  User idUser;
  @OneToMany(fetch = FetchType.EAGER)
  List<Comment> comments;
}