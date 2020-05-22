while ((sCurrentLine = br.readLine()) != null) {
        String [] s = sCurrentLine.split(":"); //split the string

        if ("tfUsername".equals(s[0])) {
            if ("tfPassword".equals(s[1]))
                JOptionPane.showMessageDialog(null, "Welcome!!");
        } else
            JOptionPane.showMessageDialog(null,"Invalid Username or Password");
    }