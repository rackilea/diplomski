for (String s : user_country) {
        UserCountry userCountry = new UserCountry();
        userCountry.setUserId(intIdUser);
        userCountry.setCountryId(Integer.parseInt(s));

        session.getTransaction().begin();
        session.persist(userCountry);
        session.getTransaction().commit();
    }