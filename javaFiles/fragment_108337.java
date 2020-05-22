public class JwtAuthorizationTokenFilter extends OncePerRequestFilter {

        private final Logger logger = LoggerFactory.getLogger(this.getClass());

        private final UserDetailsService userDetailsService;
        private final JwtTokenUtil jwtTokenUtil;
        private final String tokenHeader;

        public JwtAuthorizationTokenFilter(UserDetailsService userDetailsService, JwtTokenUtil jwtTokenUtil, @Value("${jwt.header}") String tokenHeader) {
            this.userDetailsService = userDetailsService;
            this.jwtTokenUtil = jwtTokenUtil;
            this.tokenHeader = tokenHeader;
        }


[.....]