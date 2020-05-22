// Additionally using MY_KEY as "value" parameter of this annotation
// is not working in some cases
@InitBinder
public void initBinder(WebDataBinder webDataBinder, HttpServletRequest servletRequest) {

    // Probably you only want to init this when form is submitted
    if (!"POST".equalsIgnoreCase(httpServletRequest.getMethod()) {
        return;
    }

    // Filter out all request when we have nothing to do
    Object nonCastedTarget = webDataBinder.getTarget();
    if (nonCastedTarget == null || !(nonCastedTarget instanceof MyModel)) {
        return;
    }

    MyModel target = (MyModel) nonCastedTarget;
    if (/* some condition */) {
        target.setFruit(new Apple());
    } else {
        target.setFruit(new Banana());
    }
}