import org.springframework.security.core.userdetails.User;
...
...
Set<SimpleGrantedAuthority> userRoles = new HashSet<>();
userRoles.add(new SimpleGrantedAuthority("ROLE_USER"));
User user = new User(anotherUserName, "", userRoles);
List<SessionInformation> sessions = sessionRegistry.getAllSessions(u, false);

for(SessionInformation info : infos) {
   info.expireNow();
}