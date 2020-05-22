@Transactional
public void makeChanges(Long id) {

   User user = userRepository.findOne(id);
   user.setName("Someone");
}