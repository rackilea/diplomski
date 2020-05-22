interface User {
    void exit();
}

class ExitController {
    void exit(User user) {
        user.exit();
    }
}

class UserX implements User {
    public void exit() {
        // Terminate program.
    }
}

class UserY implements User {
    public void exit() {
        // Logoff user.
    }
}