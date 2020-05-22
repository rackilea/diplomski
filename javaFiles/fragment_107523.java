TextInputDialog dialog = new TextInputDialog("password");
dialog.setContentText("Please enter your password:");

String pwd = null;
int numAttempted = 0;
int MAX_ATTEMPTS = 3;

Optional<String> result;
boolean isCorrectPwd = false;
do {
    result = dialog.showAndWait();
    numAttempted++;
    if (result.isPresent()) {
        String res = result.get();
        isCorrectPwd = login(res);
        if (isCorrectPwd) {
            pwd = res;
            System.out.println("CORRECT PASSWORD: " + res);
        } else {// try again -> loop
            System.out.println("WRONG PASSWORD: " + res);
        }
    }
} while (numAttempted < MAX_ATTEMPTS && !isCorrectPwd);