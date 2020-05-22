@ControllerAdvice
public class RedirectOnResourceNotFoundException {

    @ExceptionHandler(value = NoHandlerFoundException.class)
    public Object handleStaticResourceNotFound(final NoHandlerFoundException ex, HttpServletRequest req, RedirectAttributes redirectAttributes) {
        if (req.getRequestURI().startsWith("/api"))
            return this.getApiResourceNotFoundBody(ex, req);
        else {
            redirectAttributes.addFlashAttribute("errorMessage", "My Custom error message");
            return "redirect:/index.html";
        }
    }

    private ResponseEntity<String> getApiResourceNotFoundBody(NoHandlerFoundException ex, HttpServletRequest req) {
        return new ResponseEntity<>("Not Found !!", HttpStatus.NOT_FOUND);
    }
}