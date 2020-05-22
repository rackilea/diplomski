public Class<?> getMaxPermissionLevel(Long userID) {
        if (userID != null && userID == uid) {
            return SecureViews.User.class;
        }
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return SecureViews.Authenticated.class;
        }

        return SecureViews.Public.class;
    }