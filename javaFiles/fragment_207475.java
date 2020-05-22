if (passwordEncoder.matches(changePasswordForm.getOldPassword(),
                                user.getPassword())) {
    // ok
} else {
    // wrong old password
}