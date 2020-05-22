public Task<Void> signInTask() {
    return new Task<Void>() {

        @Override
        protected Void call() throws Exception {

            User user = Authenticator.authenticated(userNameText.getText(), passwordText.getText());
            if(user != null){
                 Shift shift = ShiftDAO.getShift(user.getUserId(), user.getBranchId(), user.getComId());
                 if(shift != null){
                     // logic if user has a shift
                 } else {
                     // logic if user has no shift, throw exception, etc.
                 }
            } else {
                 // logic if user is not authenticated, throw exception, etc.
            }
            return null;
        }
    }
}