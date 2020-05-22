FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener( MyActivity.this,  new OnSuccessListener<InstanceIdResult>() {
         @Override
         public void onSuccess(InstanceIdResult instanceIdResult) {
               String newToken = instanceIdResult.getToken();
               Log.e("newToken",newToken);

         }
     });