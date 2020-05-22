UserService userService = mock(UserService.class);
User user = mock(User.class);
when(userService.getUserById(anyLong())).thenReturn(user);

...

// invoke the method being tested

...

verify(user).setPasswordChangeRequired(true);