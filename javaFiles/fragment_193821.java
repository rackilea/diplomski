public abstract class BaseRequest<TResponse> : Request<TResponse>
{
    // ...
}

public class GetJsonRequest<TResponse> : BaseRequest<TResponse>
{
    public class Builder
    {
        // ...
        public GetJsonRequest<TResponse> Build()
        {
            // ...
            return new GetJsonRequest<TResponse>(uri, page);
        }
    }

    // ...

    public TResponse send(Func<string, TResponse> responseParser)
    {
        // ...
    }
}