List<User> selectedUsers = new ArrayList<User>(
           Iterables.filter(
                  this.getUsers(),
                  new Predicate<User>()
                      {
                          public boolean apply(User usr){ 
                                return usr.isSelected();
                          }
                       }
           ));