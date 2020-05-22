boolean checkedMails(String[] mails) {

    boolean isGood = true;
    for (int i = 0; i < mails.length; i++) {


        if (!isEmailValid(mails[i])) {

            wrongEmails.add(mails[i]);
            Log.d("WRONGEMAILS", wrongEmails.toString());
            isGood = false;
        }


    }
    return isGood;
}