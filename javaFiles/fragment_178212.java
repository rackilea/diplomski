Call<String> call = service.deletDialogflow(DialogflowService.BEARER+DialogflowService.TOKEN_DIALOGFLOW);
 call.enqueue(new Callback<String>() {
   @Override
   public void onResponse(Call<String> call, Response<String> response) {
      if (response.isSuccessful()) {
        Log.e("Successful Delete", "" + response.body().toString());
        }
        else{
        Log.e("Fail Delete", "" + response.errorBody().string());
        }

   }

   @Override
   public void onFailure(Call<String> call, Throwable t) {
       Log.e("UnSuccessful Delete", "" + t.getMessage());
   }
});