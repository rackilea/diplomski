public void doSomething() {
    HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    doSomething(request);
}

void doSomething(HttpServletRequest request) {
   // put your business logic here, and test this method
}