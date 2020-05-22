if( x >= guildsArray.size())
      guildsArray.add(new ArrayList());
for (int i = 0; i < Guild.length; i++) {
    ((ArrayList)guildsArray.get(x)).add(Guild[i]);
    if(sender.getName().equals(Guild[1])) {
      //The person is the owner of Guild[0]
      ownerOfGuild = Guild[0];
    }
  }