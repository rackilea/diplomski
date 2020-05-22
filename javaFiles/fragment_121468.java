when(userRepository.save(any(User.class)))
   .thenReturn(
      new User(UUID.fromString("e7485042-b46b-11e9-986a-b74e614de0b0"), 
              "Max", 
              productSet, 
              date, 
              null)
   );