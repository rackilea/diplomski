Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                    .build();

ChatRequest chatRequest = new ChatRequest();
chatRequest.setGroup_id("dsdfjlds9u");
UserBean userBean = new UserBean();
userBean.setUser_Id(8);
chatRequest.setUsers(Collections.singletonList(userBean));