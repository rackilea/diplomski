if (!name.isEmpty() && !name.length() < 4) && (!password.isEmpty() &&!(password.length()<5))  && isValidEmail(emailId)) {
        registerUser(name, email, password);
    } else {
        Toast.makeText(getApplicationContext(),
                "Something is Wrong! ", Toast.LENGTH_LONG)
                .show();
    }