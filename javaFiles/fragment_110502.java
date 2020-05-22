public class CustomModelAttributeMethodProcessor extends ModelAttributeMethodProcessor {

public CustomModelAttributeMethodProcessor(boolean annotationNotRequired) {
    super(annotationNotRequired);
}

@Override
protected void bindRequestParameters(final WebDataBinder binder, final NativeWebRequest request) {
    HttpServletRequest servletRequest = request.getNativeRequest(HttpServletRequest.class);
    ((ServletRequestDataBinder) binder).bind(servletRequest);
}

@Override
protected void validateIfApplicable(final WebDataBinder binder, final MethodParameter parameter) {
    if (binder.getTarget().getClass().equals(Id.class)) {
        binder.validate();
        return;
    }

    super.validateIfApplicable(binder, parameter);
}