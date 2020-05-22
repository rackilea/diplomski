public class CustomTokenEnhancer implements TokenEnhancer {

        @Autowired
        EmployeeService employeeService;

        @Override
        public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

            User user = (User) authentication.getPrincipal();
            String username = user.getUsername();

            List<Map<String, Object>> credential = employeeService.fetchEmployeesRoleCredentials(username);

                final Map<String, Object> additionalInfo = new HashMap<>();

                additionalInfo.put("credentials", credential);
                // additionalInfo.put("authorities", user.getAuthorities());

                ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);

            return accessToken;

        }

    }