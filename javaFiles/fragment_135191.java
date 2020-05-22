UserEntity userEntity = em.find(UserEntity.class, id);
UserDTO userDTO = new UserDTO();
userDTO.setId(userEntity.getId());
userDTO.setName(userEntity.getName());
// ...
return userDTO;