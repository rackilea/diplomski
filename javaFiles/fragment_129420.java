public class CustomUser extends org.springframework.security.userdetails.User {.....}

@Entity
public class UserEntity {...}

public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

 UserEntity userEntity = this.customUserRepository.findByUsername(username);

 CustomUser customUser = new CustomUser( userEntity.getUsername(), userEntity.getPassword()........);

 return customUser;
}