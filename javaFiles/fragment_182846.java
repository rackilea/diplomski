public class AddHeadersFilter implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        requestSpec.header(new Header(IntegrationBaseTest.HEADER_USER_NAME, "test-user"));

        return ctx.next(requestSpec, responseSpec);
    }

}