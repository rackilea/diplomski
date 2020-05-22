List<Player> users = new ArrayList<Player>(oldList);

  for(String newUser: newList)
  {
      if (!users.contains(newUser)) {
          users.add(newUser);
      }
  }