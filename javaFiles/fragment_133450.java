private void runSql(String pSql) {
        String tCommand = "mysql -u " + username + (password != null ? " -p" + password : "") + " " + dbName;
        System.out.println(tCommand);

        try {
            Process tProcess = Runtime.getRuntime().exec(tCommand);
            OutputStream tOutputStream = tProcess.getOutputStream();
            Writer w = new OutputStreamWriter(tOutputStream);
            System.out.println(pSql);
            w.write(pSql);
            w.flush();

            Scanner in = new Scanner(tProcess.getErrorStream());

            String errorMessage = "";

            while (in.hasNext()) {
                errorMessage += in.next() + " ";
            }

            if (errorMessage.length() > 0) {
                System.out.println(errorMessage);
                throw new ClientSqlExecutionException(errorMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }