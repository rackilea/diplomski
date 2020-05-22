public final class ValidationFilterFactory implements ResourceFilterFactory {

    @Override
    public List<ResourceFilter> create(AbstractMethod abstractMethod) {

        //keep track of required query param names
        final ImmutableSet.Builder<String> requiredQueryParamsBuilder =
                ImmutableSet.builder();

        //get the list of params from the resource method
        final ImmutableList<Parameter> params =
                Invokable.from(abstractMethod.getMethod()).getParameters();

        for (Parameter param : params) {
            //if the param isn't marked as @Nullable,
            if (!param.isAnnotationPresent(Nullable.class)) {
                //try getting the @QueryParam value
                @Nullable final QueryParam queryParam =
                        param.getAnnotation(QueryParam.class);
                //if it's present, add its value to the set
                if (queryParam != null) {
                    requiredQueryParamsBuilder.add(queryParam.value());
                }
            }
        }

        //return the new validation filter for this resource method
        return Collections.<ResourceFilter>singletonList(
                new ValidationFilter(requiredQueryParamsBuilder.build())
        );
    }

    private static final class ValidationFilter implements ResourceFilter {

        final ImmutableSet<String> requiredQueryParams;

        private ValidationFilter(ImmutableSet<String> requiredQueryParams) {
            this.requiredQueryParams = requiredQueryParams;
        }

        @Override
        public ContainerRequestFilter getRequestFilter() {
            return new ContainerRequestFilter() {
                @Override
                public ContainerRequest filter(ContainerRequest request) {

                    final Collection<String> missingRequiredParams =
                            Sets.difference(
                                    requiredQueryParams,
                                    request.getQueryParameters().keySet()
                            );

                    if (!missingRequiredParams.isEmpty()) {

                        final String message =
                                "Required query params missing: " +
                                Joiner.on(", ").join(missingRequiredParams);

                        final Response response = Response
                                .status(Status.BAD_REQUEST)
                                .entity(message)
                                .build();

                        throw new WebApplicationException(response);
                    }

                    return request;
                }
            };
        }

        @Override
        public ContainerResponseFilter getResponseFilter() {
            return null;
        }
    }
}