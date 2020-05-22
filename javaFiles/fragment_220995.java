public void getFacebookData(AccessToken accessToken, Profile profile) {
    System.out.println("---------------------");
    profile = Profile.getCurrentProfile(); // Add this 
   if (profile != null) 
   {
    System.out.println("--First Name : " + profile.getFirstName());
    System.out.println("--Last Name : " + profile.getLastName());
    System.out.println("--URL Perfil: " + profile.getLinkUri());
    System.out.println("--URL Imagem: " + profile.getProfilePictureUri(500, 500));
    System.out.println("---------------------");
    System.out.println("--ID : " + profile.getId());
    System.out.println("--Name : " + profile.getName());
    System.out.println("---------------------");

   }