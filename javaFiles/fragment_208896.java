@Order(Ordered.HIGHEST_PRECEDENCE)
public class PerformanceLogFilter extends OncePerRequestFilter {

    private static final DateTimeFormatter FORMAT 
            = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return !logger.isInfoEnabled();
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException
    {
        Instant start = Instant.now();
        try {
            filterChain.doFilter(request, response);
        } finally {
            // N.B. commons-logging, not slf4j
            logger.info(String.format("%s %s: %.1f ms",
                    start.atZone(ZoneId.systemDefault()).format(FORMAT),
                    request.getRequestURI(),
                    start.until(Instant.now(), ChronoUnit.MICROS) * 1e-3
            ));
        }
    }