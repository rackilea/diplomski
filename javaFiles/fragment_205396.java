private boolean mHasReceivedData = false;
@Override
public void onResponse(String response) {
  volleyResult = response;
  mHasReceivedData = true;
}

public void courses(View view){
  // your code that relies on the volley response
  if(mHasReceivedData){
        Log.i("Volley Res", volleyResult);
  }
}