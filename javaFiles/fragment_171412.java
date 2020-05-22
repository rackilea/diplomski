public class MockHttpServletRequest implements HttpServletRequest {

    @Override
    public String getMethod() {
        return "POST";
    }
    ...
}