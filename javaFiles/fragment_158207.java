public boolean isUseJoin() {
        if(!adress.equals("") && !phoneNumber.equals("")&&!name.equals("")) {
            return true;
        } else {
            return false;
        }
    }