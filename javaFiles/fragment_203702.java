public class CustomPasswordEncoder implements PasswordEncoder{

    @Override
    public String encode(CharSequence rawPassword) {
      return DigestUtils.md5DigestAsHex(rawPassword.toString().getBytes());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String rawEncoded = encode(rawPassword);
        return Objects.equals(rawEncoded, encodedPassword);
    }
}