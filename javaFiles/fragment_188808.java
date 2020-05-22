public class UserService {
     public User findUser(String id){
          log.info("Invoked method: get with ID: " + id);
          log.warn("Searching for user with ID " + id);
          User user = userRepository.findOne(id);
          if (user == null){
            log.error("Unexpected error, User with ID " + id + " not found");
            throw new NotFoundException("User with ID " + id + " not found");
          }
         log.info("User found. Sending request back. ID of user is " + id);
         return user;
     }
}