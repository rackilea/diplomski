HttpSession session = request.getSession();

if (!session.isNew()) {
    session.invalidate();
    session = request.getSession();
}