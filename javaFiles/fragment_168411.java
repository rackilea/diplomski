try {

            fileList = mService.files().list().setSpaces("appDataFolder").execute();
            //...
            return null;
        } catch (UserRecoverableAuthIOException e) {
            e.printStackTrace();
            errorCode = 1;
            startActivityForResult(e.getIntent(), REQUEST_SIGNIN_REQUIRED);
            return true;
}