if(rs.next()) // Successful login
    {
        Window_AfterLogin window_afterlogin = new Window_AfterLogin(user);
        window_afterlogin.setVisible(true);
        this.dispose();
    }