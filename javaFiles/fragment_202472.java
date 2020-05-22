@Override
public ApiResponseDto getlogin(UserDto usersLogin) {
    try {
        // Assumption: The connection is pooled, and doesn't require closing.
        Connection con = getConnection();
        try (Preparestament ps = con.preparestament("select * from tableregister where username = ? and password = ?") {
            ps.setString(1, usersLogin.getUsername());
            ps.setString(2, userLoging.getPassword());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                   return new ApiResponseDto("Success", "Login Success");
                } else {
                    ApiResponseDto obj = new ApiResponseDto("Error", "Error Login");
                    obj.setErrorCode(1);
                    return obj;
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace(); // Or log the error somehow
        return new ApiResponseDto("Error", "Error: " + e.toString());
    }
}