boolean userNameFound = false;
            while (line != null) {
                Matcher userNameAndPasswordMatcher = usernameAndPasswordPattern.matcher(line);

                if (userNameAndPasswordMatcher.matches()) {
                    String username = userNameAndPasswordMatcher.group(1);
                    String password = userNameAndPasswordMatcher.group(2);
                    String bestScore = userNameAndPasswordMatcher.group(3);

                    String pwd = new String(passField.getPassword());

                    if (username.equals(usernameField.getText())) {
                        userNameFound = true;
                        if (password.equals(pwd)) {
                            gd.setCurrentUser(username);
                            gd.setBestScore(Integer.parseInt(bestScore));

                            rdialog = new RedirectingDialog(frame);
                            rdialog.setVisible(true);
                        } else { // password does not match
                            int result = JOptionPane.showConfirmDialog(null, "Incorrect password!", "Login incomplete", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                            if (result == JOptionPane.OK_OPTION) {
                                passField.setText("");
                            }                           
                        }
                        break;
                    }
                }
            }
            if (! userNameFound) {
                int result = JOptionPane.showConfirmDialog(null, "Incorrect password!", "Login incomplete", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    passField.setText("");
                }                           
            }