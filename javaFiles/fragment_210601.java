for (RosterEntry rosterEntry : collection)
  {
    Presence presence = null;
    presence = roster.getPresence(rosterEntry.getUser());

    if(presence.isAvailable())
    {
      //Do Something
    }
    else{
      //Do Something else
    }
  }