try {
        getUsermanagerService().logUser(username, password);

        return SUCCESS;
    } catch (DataAccessException e) {
        e.printStackTrace();
    }