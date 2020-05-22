private Set<User> _usrs = new HashSet<>();
/*
 *  function that I use before I get the current user set, preventing getting a outdated version of it
 */
public void refreshUserList() {
    this._usrs.addAll(_employees); //add all employees to user set
    this._usrs.addAll(_managers);  //add all managers to user set
}