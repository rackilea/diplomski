private void loadJSON() {

    Retrofit retrofit = new Retrofit.Builder()
          //
          // here goes your retrofit code             
          //
    Call<HomeResponse> call = request.getHomeJSON();

    call.enqueue(new Callback<HomeResponse>() {
        @Override
        public void onResponse(Call<HomeResponse> call, Response<HomeResponse> response) {
            //
            // here goes your code             
            //
             activity.stopBar();


        }





        @Override
        public void onFailure(Call<HomeResponse> call, Throwable t) {
               //
               // here goes your code             
               //

              activity.stopBar();

            Error_Dialog alert = new Error_Dialog();
            alert.showDialog(getActivity()," Please Check Your Internet Connection");

        }
    });

}