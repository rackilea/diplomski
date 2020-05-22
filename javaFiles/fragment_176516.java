Map<String,Academics> academicsByID = userList.stream().collect(Collectors.toMap(Academics::getID,Function.identity));

List<Profile> profiles = 
    userList.stream()
                 .map(u -> {
                     Profile p = new Profile ();
                     Academics a = academicsByID.get(u.getID());
                     // now set all the Profile fields based on the properties
                     // of the Users instance (u) and the Academics instance (a)
                     // (if available)
                     return p;
                 })
                 .collect(Collectors.toList());