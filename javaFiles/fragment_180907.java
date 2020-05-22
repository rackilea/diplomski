@Test(expected = UsernameNotFoundException.class)
public void should_Throw_UserNameNotFoundException_If_UserIsNotFound() {
    Mockito
       .when(userRepository.findByUsername(fakeUser))
       .thenThrow(UsernameNotFoundException.class);
   userServiceImpl.loadUserByUsername(fakeUser);
}