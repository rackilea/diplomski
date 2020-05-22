public interface MultipartResolver {
 /* Parse the given HTTP request into multipart files and parameters,
 * and wrap the request inside a
 * {@link org.springframework.web.multipart.MultipartHttpServletRequest} object
 * that provides access to file descriptors and makes contained
 * parameters accessible via the standard ServletRequest methods.
 * ....
 */
 MultipartHttpServletRequest resolveMultipart(HttpServletRequest request) throws MultipartException;