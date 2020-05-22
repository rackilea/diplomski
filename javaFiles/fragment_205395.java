@Override
public void onResponse(String response) {
  volleyResult = response;
  methodToHoldUntilResponseArrived();
}

public void methodToHoldUntilResponseArrived(){
  // your code that relies on the volley response
  Log.i("Volley Res", volleyResult);
}