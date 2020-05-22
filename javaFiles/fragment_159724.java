public class CustomErrorFilter extends ZuulFilter {

private static final Logger LOG = LoggerFactory.getLogger(CustomErrorFilter.class);

@Override
public String filterType() {
    return "post";
}

@Override
public int filterOrder() {
    return -1; 
}

@Override
public boolean shouldFilter() {
    RequestContext ctx=RequestContext.getCurrentContext();
    if(ctx.getThrowable()!=null)
        return true;
    else
       return false;
}

@Override
public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();

            ctx.setThrowable(null); // response is not returned unless 
                                      throwable is set to null.
            ctx.remove("error.status_code");

            ctx.setResponseBody(“Error”);
            ctx.getResponse().setContentType("text/plain");
            ctx.setResponseStatusCode(400);

    }

    return null;
}