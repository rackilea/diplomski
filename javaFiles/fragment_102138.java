try {
        File fDb = new File(this.inputDirectory + File.separator + dbName);

        String cmdForRuntime =  "\"" + cmdScript.getAbsolutePath() + "\"" + " " +       // the script to be executed 
                                "\"" + prog.getAbsolutePath() + "\"" + " " +            // sqlite3cipher.exe
                                "\"" + fDb.getAbsolutePath() + "\"" + " " +             // testdb
                                "\"" + fSqlScript.getAbsolutePath() + "\"";             // statements.sql

        logger.info("Executing command: " + cmdForRuntime );

        Process process = Runtime.getRuntime().exec( cmdForRuntime );

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String s;

        while ((s = stdIn.readLine()) != null) {
            logger.info("OUTPUT FROM PROG: " + s);
        }

        if (process.waitFor() == 0) {
            logger.info("Process finished");
        }
        else {
            logger.error("!!!! error !!!!");
            // Get input streams
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            System.out.println("Standard error: ");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        }
    }
    catch(Exception ioe) {
        ioe.printStackTrace();
    }