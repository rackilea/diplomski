public class Vconnection {

private static Vconnection nInstance;
private RequestQueue RQ;
private Context CTX;

private Vconnection(Context context)
{
    CTX=context;
    RQ=getRequestQue();

}

public RequestQueue getRequestQue()
{
    if(RQ==null)
    {
        RQ= Volley.newRequestQueue(CTX.getApplicationContext());
    }
    return RQ;
}
public static synchronized Vconnection getnInstance(Context context)
{
    if(nInstance==null)
    {
        nInstance=new Vconnection(context);
    }
    return nInstance;
}
public <T> void addRequestQue(Request<T> request)
{
    int socketTimeout = 30000;
    RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
    request.setRetryPolicy(policy);
    RQ.add(request);
}