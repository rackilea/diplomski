@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserDTO userDTO = (UserDTO) o;
    return (Objects.equal(username, userDTO.username) && Objects.equal(password, userDTO.password) && Objects.equal(email, userDTO.email));        
}