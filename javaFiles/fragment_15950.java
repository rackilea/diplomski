@Query("SELECT * FROM users WHERE id =:userID")
Users getUser(int userID);

@Query("SELECT * FROM users")
List<Users> getAll();

@Insert
void insert(Users users);