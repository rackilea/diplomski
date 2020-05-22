@Test
public void testFindAllUser() {
User user1 = new User();
user1.setId(DEFAULT_ID);
User user2 = new User();
user2.setId(2L);
List<User> userList = new ArrayList<>();
userList.add(user1);
userList.add(user2);
Pageable pageable = PageRequest.of(0, 5);
Page<User> userPage = new PageImpl<>(userList, pageable, userList.size());

UserDto userDto1 = new UserDto();
userDto1.setId(Long.valueOf(1));
UserDto userDto2 = new UserDto();
userDto2.setId(Long.valueOf(2));
List<UserDto> userDtoList = new ArrayList<>();
userDtoList.add(userDto1);
userDtoList.add(userDto2);
Page<UserDto> userDtoPage = new PageImpl<>(userDtoList, pageable, userDtoList.size());

Mockito.when(userMapperMock.toDto(user1)).thenReturn(userDto1);
Mockito.when(userMapperMock.toDto(user2)).thenReturn(userDto2); //Mocking the toDto method. 

Mockito.when(userRepositoryMock.findAll(pageable)).thenReturn(userPage);
assertThat(userService.findAll(pageable)).isEqualTo(userDtoPage);
}