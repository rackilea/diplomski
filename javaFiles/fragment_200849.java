public class FirstInterceptor implements ServerInterceptor {
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
             ServerCall<ReqT, RespT> call,
             Metadata headers,
             ServerCallHandler<ReqT, RespT> next) {
         if(...) {
             ...
             return Contexts.interceptCall(context, call, headers, next);
         } else {
             ...
             call.close(Status.UNAUTHENTICATED.withDescription("@FST_INTCP"),
                 GrpcUtil.getMetadataWithErrMsg(e));
             return new ServerCall.Listener() {};
         }
     }
}