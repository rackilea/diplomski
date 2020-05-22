@Test
public void editProfileTest() { 
    String mediaType = MediaType.APPLICATION_JSON;        
    when(profileDao.find(2L)).thenReturn(profileList.get(0));
    final Entity<Profile> entity = Entity.entity(profileService.getProfile(2L), mediaType);
    Profile profileResult = this.root.path("edit/2").request().post(entity, Profile.class);
    assertThat(profileResult.getId(), is(profileService.getProfile(2L).getId()));
    assertThat(profileResult.getUser_id(), is(profileService.getProfile(2L).getUser_id()));
    assertThat(profileResult.getAvatar(), is(profileService.getProfile(2L).getAvatar()));
    assertThat(profileResult.getBiography(), is(profileService.getProfile(2L).getBiography()));
    assertThat(profileResult.getLocation(), is(profileService.getProfile(2L).getLocation()));
    assertThat(profileResult.getWebsite(), is(profileService.getProfile(2L).getWebsite()));
    assertThat(profileResult.getImage(), is(profileService.getProfile(2L).getImage()));
}