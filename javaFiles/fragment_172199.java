@Async
public Future<SocialLogin> loginUserSocial(Social model) {
        Session session = this.sessionFactory.openSession();
        session.save(model);
        SocialLogin dto = new SocialLogin();
        dto.setUser_id(model.getUser_id());
        return new AsyncResult<SocialLogin>(dto);
    }