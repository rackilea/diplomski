while ((sCurrentLine = br.readLine()) != null) {
        try {
        // your code

        } catch(SQLIntegrityConstraintViolationException e){
            sCurrentLine = br.readLine();
        } 
    }