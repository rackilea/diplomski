try ( final JsonReader jsonReader = getPackageResourceJsonReader(Q43929916.class, "loginResponse.json") ) {
    final LoginResponse loginResponse = gson.fromJson(jsonReader, LoginResponse.class);
    for ( final InvitationResponse invitation : loginResponse.invitations ) {
        System.out.println(invitation.inviteData);
    }
}