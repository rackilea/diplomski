public void getMovies() {

      ProgressDialog mProgressDialog = new ProgressDialog(this);
      mProgressDialog.setIndeterminate(true);
      mProgressDialog.setMessage("Loading...");
      mProgressDialog.show();
      MovieClient.getWeather().movies(MovieClient.getRandomMovie(), new Callback<MovieRequest>() {
      @Override
      public void success(MovieRequest movieRequest, Response response) {

         Picasso.with(getApplicationContext()).load(movieRequest.getPoster()).into(image);

         if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();


    }

      @Override
      public void failure(RetrofitError error) {
          if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();

          Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

      }
   });
}