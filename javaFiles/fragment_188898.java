@Entity(name = "auth_user")
public class User implements UserDetails {

   @Id
   @Column
   private String id;

   @Column(nullable = false, unique = true)
   private String name;


   @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
   /** 
    * relation to our roles
   **/
   private Set<Role> roles = new HashSet<Role>();

   /**
   * implements getAuthorities and transformes our Roles using the unique names to 
   * SimpleGrantedAuthority
   **/
   public Collection<? extends GrantedAuthority> getAuthorities() {
     Set<GrantedAuthority> authList = new HashSet<GrantedAuthority>();

     for (Role role : user.getRoles()) {
       authList.add(new SimpleGrantedAuthority(role.getName()));
     }        

     // Return list of granted authorities
     return authList;
   }
}