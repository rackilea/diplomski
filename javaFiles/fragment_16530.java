/**
     * checks if a pst file is password protected
     * 
     * @param file - pst file to check 
     * @return - true if protected,false otherwise
     * 
     * pstfile has the password stored against identifier 0x67FF.
     * if there is no password the value stored is 0x00000000.
     */
    private static boolean ifProtected(PSTFile file,boolean reomovePwd){
        try {
            String fileDetails = file.getMessageStore().getDetails();
            String[] lines = fileDetails.split("\n");
            for(String line:lines){
                if(line.contains("0x67FF")){
                    if(line.contains("0x00000000"))
                        return false;
                    else
                        return true;
                }

            }
        } catch (PSTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }