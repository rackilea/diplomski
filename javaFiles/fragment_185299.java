@Entity
public class LoginDetails {
    @Column(name = "password")
    private byte[] encryptedPassword;

    @Transient
    private String password;

    public void getPassword() {
        if (password == null) {
            password = CryptoUtils.decrypt(encryptedPassword);
        }
        return password;
    }

    public void setPassword(String password) {
        this.encryptedPassword = CryptoUtils.encrypt(password);
        this.password = password;
    }
}