public void getRetrofit() {

  isLoadingData = true; // <--- flag

  // ....

  final Call < List < WPPost >> call = service.getPostInfo(url);
  call.enqueue(new Callback < List < WPPost >> () {
    @Override
    public void onResponse(Call < List < WPPost >> call, Response < List < WPPost >> response) {
      isLoadingData = false; // <--- flag
      // ...
    }

    @Override
    public void onFailure(Call < List < WPPost >> call, Throwable t) {
      isLoadingData = false; // <--- flag
    }
  });
}