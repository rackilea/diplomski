Session sessionRead = null;
        try {
            sessionRead = jsch.getSession(user, host, port);
        } catch (JSchException e) {
            System.out.println("Issue getting session.");
            e.printStackTrace();
        }

        try {
            sessionRead.connect(); // do you need to set properties first?
        } catch (JSchException e) {
            System.out.println("Issue connecting to session.");
            e.printStackTrace();
        }