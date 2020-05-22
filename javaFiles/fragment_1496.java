public class PersonControllerTest {

    private PersonController personController;
    private MockHttpServletRequest request;

    private MessageSource messageSource;

    @Before
    public void setUp() {
        request = new MockHttpServletRequest();
        request.setMethod("POST");

        personController = new PersonController();

        messageSource = new ResourceBundleMessageSource();
        ((ResourceBundleMessageSource) messageSource).setBasename("myMessages");
    }

    @Test
    public void failureSubmission() throws Exception {
        /**
         * Ops... a bindException
         * 
         * Age can not be a plain String, It must be a plain Integer
         */
        request.addParameter("age", "not a meaningful age");

        ModelAndView mav = personController.handleRequest(request, new MockHttpServletResponse());

        BindingResult bindException = (BindingResult) mav.getModel().get(BindingResult.MODEL_KEY_PREFIX + "command");
        for (Object object : bindException.getAllErrors()) {
            if(object instanceof FieldError) {
                FieldError fieldError = (FieldError) object;

                assertEquals(fieldError.getField(), "age");

                /**
                  * outputs typeMismatch.command.age
                  */
                System.out.println(messageSource.getMessage((FieldError) object, null));
            }
        }
    }

}