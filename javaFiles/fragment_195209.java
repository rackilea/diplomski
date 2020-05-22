OnCompleteListener<AuthResult> completeListener = new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
                boolean isNew = task.getResult().getAdditionalUserInfo().isNewUser();
                Log.d("MyTAG", "onComplete: " + (isNew ? "new user" : "old user"));
            }
        }
    };