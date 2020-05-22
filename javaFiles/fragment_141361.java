for (int i = 0; i < users.size(); i++) {
        if (users.get(i).getUsername().compareTo(username) == 0 && users.get(i).getPassword().compareTo(password) == 0) {
            return true;
        }
    }
    passwordField.setText("");
    Toolkit.getDefaultToolkit().beep();
    JOptionPane.showMessageDialog(errorFrame,
            "Could not authorize employee with given username and password.\n\n"
            + "Please reenter or contact your system administrator.\n\n",
            "Employee Authorization Failed",
            JOptionPane.ERROR_MESSAGE);
    return false;