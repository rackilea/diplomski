User user = (User) request.getSession().getAttribute("user");
SomeContext someContext = SomeContext.newInstance(user);

try {
    chain.doFilter(request, response);
} finally {
    // It's very important to do this in finally!
    // Threads are namely pooled by the container.
    someContext.release();
}