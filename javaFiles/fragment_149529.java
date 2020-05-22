protected Session wrap(Session session) {
    final TransactionProtectionWrapper wrapper = new TransactionProtectionWrapper( session );
    final Session wrapped = (Session) Proxy.newProxyInstance(
            Session.class.getClassLoader(),
            SESSION_PROXY_INTERFACES,
            wrapper
    );
    wrapper.setWrapped( wrapped );
    return wrapped;
}