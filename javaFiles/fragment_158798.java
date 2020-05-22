@ExceptionHandler(IllegalStateException.class)
public RedirectView handleIllegalStateException(IllegalStateException ex, HttpServletRequest request) {
    RedirectView rw = new RedirectView("/error");
    FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);
    if (outputFlashMap != null) {
        outputFlashMap.put("exceptionMsg", ex.getMessage());
    }
    return rw;
}