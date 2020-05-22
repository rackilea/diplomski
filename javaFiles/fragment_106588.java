String value = "whatever";
boolean isServletNeedRefresh = true;

if(value.equals("whatever")){
   // stop refreshing the page 
   isServletNeedRefresh = false;
}

if (isServletNeedRefresh)
{
    response.setIntHeader("Refresh", 3); 
}