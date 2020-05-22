SocialAuthManager manager = (SocialAuthManager)session.getAttribute("authManager");

   AuthProvider provider = manager.connect(paramsMap);

  // get profile
  Profile p = provider.getUserProfile();

  // you can obtain profile information
  System.out.println(p.getFirstName());

  // OR also obtain list of contacts
  List<Contact> contactsList = provider.getContactList();