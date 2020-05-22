@Provider
public class Filter implements ClientRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(Filter.class);

    @Override
    public void filter(ClientRequestContext ctx) throws IOException {
        try {
            logger.debug("Before: {}", ctx.getUri());
            //this is gonna get ugly
            ctx.setUri(new URI(
                URLDecoder.decode(ctx.getUri().toString(), StandardCharsets.UTF_8.toString())));
            logger.debug("After: {}", ctx.getUri());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}