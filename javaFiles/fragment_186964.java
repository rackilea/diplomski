public T update(T object) {
    Session session = getSession();
    session.update(object);
    session.flush();
    return object;
}