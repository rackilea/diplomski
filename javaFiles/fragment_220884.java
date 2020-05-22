@Override
public void onStart(){
    super.onStart();
    if(this.googleApiClient != null){
            this.googleApiClient.connect();
    }
}