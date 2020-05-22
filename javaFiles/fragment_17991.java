} else {
    // Show a progress spinner, and kick off a background task to
    // perform the user login attempt.
    showProgress(true);
    Call<User> call = apiService.DataForUser(email);
    call.enqueue(new Callback<User>() {
      @Override
      public void onResponse(Call<User> call, Response<User> response) {
        user=response.body();
        if(user!=null){
          String hash_pass = Hashing.sha256()
          .hashString(password, StandardCharsets.UTF_8)
          .toString();

          if(hash_pass.equals(user.getPassword())) {
            return true;
          } else {
            return false;
          }
        } else {
          return false;
        }
      }
}