/**
 * Create an encrypted password from a clear string.
 * 
 * @param clearString
 *            the clear string
 * @return an encrypted password of the clear string
 * @throws AppException
 *             APP Exception, from NoSuchAlgorithmException
 */
public static String createPassword(String clearString) throws AppException {
    if (clearString == null) {
        throw new AppException("empty.password");
    }
    return BCrypt.hashpw(clearString, BCrypt.gensalt());
}