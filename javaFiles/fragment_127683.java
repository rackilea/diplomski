@RestController
public class CatchAllController {

    @RequestMapping("**")
    public FileSystemResource deliver(final HttpServletRequest request) {
        final String file = ((String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE));

        return new FileSystemResource(getStaticFile(file));
    }

    private File getStaticFile(final String path) {
        try {
            // TODO handle correct
            return new File(CatchAllController.class.getResource("/static/" + path + "/index.html").toURI());
        } catch (final Exception e) {
            throw new RuntimeException("not found");
        }
    }
}