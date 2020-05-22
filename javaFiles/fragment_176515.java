List<Profile> profiles = 
    academicsList.stream()
                 .map(a -> {
                     Profile p = null;
                     Users u = userByID.get(a.getID());
                     if (u != null) {
                         p = new Profile();
                         // now set all the Profile fields based on the properties
                         // of the Users instance (u) and the Academics instance (a)
                     }
                     return p;
                 })
                 .filter(Objects::nonNull)
                 .collect(Collectors.toList());