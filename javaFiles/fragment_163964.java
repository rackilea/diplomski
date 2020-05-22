public void apiCall(Parameter parameter,CallBackPresenter callBackPresenter){
  //success method
  callBackPresenter.success(datamodelObject);
  //error
  callBackPresenter.success(error);
}