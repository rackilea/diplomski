public CLogin loadLogin(String userName) throws AccessException {
        try {
            Session sesion = this._dao.init();
            CLogin login = (CLogin) sesion.createCriteria(CLogin.class).add(
                    Restrictions.ilike("_Login", userName.toLowerCase(), MatchMode.EXACT))
                    .uniqueResult();
            if (login == null) {
                throw new AccessException("User does not exist");
            }
            return login;
        } catch (HibernateException e) {
            throw new AccessException(e.getMessage(), e);
        }
    }