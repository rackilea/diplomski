@Configuration
public class BeanConfig {
    @Bean
    public MemberDAO getMemberDAO() {
        return new MemberDAO();
    }
}