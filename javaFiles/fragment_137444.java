private void saveUser(User user) {
    boolean savedUser = false;
    userRepository.addUser(user, new CustomInterface() {
                @Override
                public void handleResult(String response) {
                    if (response.equals(UserRepository.USER_ALREADY_EXISTS)) {
                        showToast(getResources().getString(R.string.user_already_exists));
                    } else if (response.equals(UserRepository.FIREBASE_ERROR)) {
                        showToast(getResources().getString(R.string.firebase_error));
                    }
                    // And Do whatever you want to do, here in this method
                }
            });
}