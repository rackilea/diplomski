Call<model> call = api.getABC();
call.enqueue(new Callback<Model>() {
        @Override
        public void onResponse(Call<Model> call, Response<Model> response) {
            if (response.isSuccessful()) {
                List<Result> results=response.body().getResults();
                for(Result result:results){
                Log.d(TAG,"Result: "+result.getVoteCount())                    
               }



            }
        }

        @Override
        public void onFailure(Call<Model> call, Throwable t) {

        }
    });