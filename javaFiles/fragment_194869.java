@Override
public String doIntercept(ActionInvocation ai) throws Exception {
    // TODO Auto-generated method stub
  System.out.println("#####Inside Interceptor#####");
  ai.invoke();
}