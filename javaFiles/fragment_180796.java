ServerSocket ss;

            try {
                ss = new ServerSocket(portIn);
                while (true) {
                    Socket s = ss.accept();
                    // Option 1: runnable class
                    new Thread(new CustomRunnableClass(s)).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }