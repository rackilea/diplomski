final User user = new User(); <--- declare a field or outer variable

FetchUserDataAsyncTask task = new FetchUserDataAsyncTask(user, new GetUserCallBack() {
      @Override
      public void done(User retUser) {
          user.username = retUser.username; // <--- set variables
          user.password = retUser.password; // <---
      }
});
task.execute(); // <----- missing this