public boolean isUserInfoComplete(User user, ArrayList list){
    for(String attribute : list) {
        String methodName = "get" + attribute.substring(0, 1).toUpperCase() + attribute.substring(1).toLowerCase();
        Method method = User.class.getMethod(methodName, null);
        if(method != null) {
            Object result = method.invoke(user);
            if(result == null) {
                return false;
            }
        }
    }
    return true;
}