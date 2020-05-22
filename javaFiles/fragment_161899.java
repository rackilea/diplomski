public final class RequestFactory<P extends RequestParams> {
    public static final RequestFactory<DeviceInfoParams> SYSTEM_INFO =
        new RequestFactory<>(DeviceInfoParams::new);
    public static final RequestFactory<InterfacesParams> INTERFACES =
        new RequestFactory<>(InterfacesParams::new);

    private final Function<ExternalArgs, P> mRequestParamsCreator;

    private RequestFactory(final Function<ExternalArgs, P> requestParamsCreator) {
        mRequestParamsCreator = requestParamsCreator;
    }

    public Request<P> create(final ExternalArgs externalArgs) {
        final P requestParams = mRequestParamsCreator.apply(externalArgs);
        return new Request<P>("get", Collections.singletonList(requestParams));
    }
}