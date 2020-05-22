public class BusinessLayerExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        ModelAndView wrappedResponse = new ModelAndView();
        wrappedResponse.setStatus(HttpStatus.BAD_REQUEST);
        wrappedResponse.setView(new YourCustomView(ex.getMessage()));
        return wrappedResponse;
    }
}