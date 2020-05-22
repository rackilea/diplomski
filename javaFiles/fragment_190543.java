static JFrame loginWindow;  <--- create as class variable, not local.
//loginFrame.add(loginPanel);  <--- doesn't appear that this is actually used

if(event.getSource() == loginBtn){
                    if (name.equals(userName) && pass.equals(password)) {
                        MainFrame.initMainFrame();
                        //loginFrame.dispose();    <--- again, not used
                        loginWindow.dispose();     <--- want to dispose
                        JOptionPane.showMessageDialog(null, "Системд нэвтэрлээ. Өнөөдөр " , " ", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        statusFld.setText("Нэр эсвэл нууц үг буруу байна.");
                    }

                }