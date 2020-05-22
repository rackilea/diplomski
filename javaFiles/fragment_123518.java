/**
 * This class is the main security configuration for working with the
 * Single-Sign On SAML backend. All it does it import the security context file
 * and configure other annotation-based options. All of the real configuration
 * options are in WEB-INF/securityContext.xml.
 * 
 * @author Jay Jay Billings
 *
 */
 @EnableWebSecurity
 @Configuration
 @EnableGlobalMethodSecurity(securedEnabled = true)
 @ImportResource("WEB-INF/securityContext.xml")
 public class SecurityConfiguration extends WebSecurityConfigurerAdapter {}