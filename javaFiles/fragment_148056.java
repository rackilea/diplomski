public User getByEmail(String email) throws DAOException {
    if (DAOFactory.getUserDAO().getByEmail(email).isEmpty()) {   // 39 line
        return null;
    } else {
        return DAOFactory.getUserDAO().getByEmail(email).get(0);
    }
}