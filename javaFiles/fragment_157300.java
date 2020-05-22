@Component
public class SecurityUtility {
    private final String SALT = "salt";
    private final Random random;

    // I prefer constructor injection...
    public SecurityUtility(@Inject Random random){
         this.random = random ;
    }
    @Bean
    public String randomPassword() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();        
        while (salt.length() < 18) {
            int index = random.nextInt(SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return  salt.toString();
    }
}