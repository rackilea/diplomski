public class RegistrationResponse {
    public int newID;

    public RegistrationResponse(int newID) {
      this.newID = newID;
    }
}

@GET
@UnitOfWork
@Timed
@Path("/create")
public RegistrationResponse register(@QueryParam("name") String name,
                     @QueryParam("password") String password) {

  String encr = enc.encrypt(password);

  User newUser = new User(name, encr);

  int newID = _userDAO.createUser(newUser);

  return new RegistrationResponse(newID);
}