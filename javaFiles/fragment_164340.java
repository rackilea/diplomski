String errorCode;
    if(task.getException()).getErrorCode() instanceof  FirebaseAuthException){
        errorCode = ((FirebaseAuthException) task.getException()).getErrorCode();

        switch(errorCode) {
            case "ERROR_EMAIL_ALREADY_IN_USE":
                Toast.makeText(LoginActivity.this, LoginActivity.this.getResources().getString(R.string.ERROR_EMAIL_ALREADY_IN_USE),
                        Toast.LENGTH_SHORT).show();
                stopIndicator();
                break;
            case "ERROR_INVALID_EMAIL":
                Toast.makeText(LoginActivity.this, LoginActivity.this.getResources().getString(R.string.ERROR_INVALID_EMAIL),
                        Toast.LENGTH_SHORT).show();
                stopIndicator();
                break;
            case "ERROR_WEAK_PASSWORD":
                Toast.makeText(LoginActivity.this, LoginActivity.this.getResources().getString(R.string.ERROR_WEAK_PASSWORD),
                        Toast.LENGTH_SHORT).show();
                stopIndicator();
                break;
            case "ERROR_CREDENTIAL_ALREADY_IN_USE":
                Toast.makeText(LoginActivity.this, "CREDENTIAL ALREADY IN USE",
                        Toast.LENGTH_SHORT).show();
                stopIndicator();
                break;
            default:
                Toast.makeText(LoginActivity.this, LoginActivity.this.getResources().getString(R.string.Error),
                        Toast.LENGTH_SHORT).show();
                stopIndicator();

        }


    }else{
         errorCode="";
    }