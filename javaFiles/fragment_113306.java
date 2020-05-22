public void fetchUser(Integer cdCode, String pinckingListNumber) {
     List<User> Users = new ArrayList<>();
        do {
            fetchUserApi(cdCode, pinckingListNumber);
            // My code modification
            synchronized (thread) {
                try {
                    thread.wait();
                } catch (InterruptedException e) {
                    callUser = false;
                    UserEvent UserEvent = new UserEvent(
                            null, 500, R.string.order_unavailable);
                    EventBus.getDefault().post(UserEvent);
                }
            }
            offset = offset + 10;
            if (!ObjectValidation.isEmptyOrNull(response)) {
                for (int i = 0; i < response.getRecords().size(); i++) {
                    Users.add(response.getRecords().get(i));
                }
                if (response.getMeta().getRecordCount() < response.getMeta().getOffset())
                    callUser = false;
            } else {
                callUser = false;
                UserEvent UserEvent = new UserEvent(
                        null, 500, R.string.order_unavailable);
                EventBus.getDefault().post(UserEvent);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                callUser = false;
                UserEvent UserEvent = new UserEvent(
                        null, 500, R.string.order_unavailable);
                EventBus.getDefault().post(UserEvent);
            }
        } while (callUser);

        UserEvent UserEvent = new UserEvent(
                Users, 200, R.string.delivery_success);
        EventBus.getDefault().post(UserEvent);
    }

    private void fetchUserApi(Integer cdCode, String pinckingListNumber) {
        UserResource userResource = getRetrofit().create(UserResource.class);
        final Call<BaseResponse<User>> callUserAPI = userResource.getListUsers(
                    authController.getTokenHeader(),
                    pinckingListNumber,
                    cdCode,
                    limit,
                    offset
            );
            // My code modification
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        updateUsersFromServer(callUserAPI.execute().body());
                        synchronized (thread) {
                            thread.notify();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            thread.start();
    }
    private void updateUsersFromServer(BaseResponse<User> baseResponseUsers) {
            response = baseResponseUsers;
        }