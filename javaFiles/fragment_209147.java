Call<List<Pin>> myCall = pinsApiInterface.getStreams();
myCall.enqueue(new Callback<List<Pin>>() {
      @Override
      public void onResponse(Call<List<Pin>> call, Response<List<Pin>> response) {
          // your response code
      }

      @Override
      public void onFailure(Call<List<Pin>> call, Throwable t) {
         // your failure code
      }
});