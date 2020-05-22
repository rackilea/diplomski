/**
 * Responsible for attaching a {@link NioReadListener} to the servlet input stream before async processing begins.
 */
public class NioDeferredResultInterceptor extends DeferredResultProcessingInterceptorAdapter {

private final DeferredResult<String> _deferredResult;
private final VaultServletRequest _request;
private final ModelMap _model;

    public NioDeferredResultInterceptor(ServletRequest request, DeferredResult<String> deferredResult, ModelMap model) {
        _deferredResult = deferredResult;
        _request = request;
        _model = model;
    }

    @Override
    public <T> void preProcess(NativeWebRequest request, DeferredResult<T> deferredResult) throws Exception {
        ReadListener readListener = new NioReadListener(_request, _deferredResult, _model);
        ServletInputStream servletInputStream = _request.getInputStream();
        servletInputStream.setReadListener(readListener);
    }