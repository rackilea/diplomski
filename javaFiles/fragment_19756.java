2014-03-09 03:56:08 DEBUG UsernamePasswordAuthenticationFilter:205 - Request is to process authentication
.........
2014-03-09 03:56:08 DEBUG SessionFixationProtectionStrategy:97 - Started new session: bq2ozweuwq07l16o2nspj4q3
2014-03-09 03:56:08 DEBUG UsernamePasswordAuthenticationFilter:319 - Authentication success. Updating SecurityContextHolder to contain: org.springframework.security.authentication.UsernamePasswordAuthenticationToken@bf69f27c: Principal: org.springframework.security.core.userdetails.User@364492: Username: test; Password: [PROTECTED]; Enabled: true; AccountNonExpired: true; credentialsNonExpired: true; AccountNonLocked: true; Granted Authorities: ROLE_ADMIN; Credentials: [PROTECTED]; Authenticated: true; Details: org.springframework.security.web.authentication.WebAuthenticationDetails@fffc7f0c: RemoteIpAddress: 0:0:0:0:0:0:0:1; SessionId: 1ajcb4rxv6p4ryg58262el5e8; Granted Authorities: ROLE_ADMIN
..................
2014-03-09 03:56:08 DEBUG SavedRequestAwareAuthenticationSuccessHandler:107 - Using default Url: /welcome
2014-03-09 03:56:08 DEBUG DefaultRedirectStrategy:36 - Redirecting to '/welcome'