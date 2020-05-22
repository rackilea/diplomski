for(String pass : splitPass){
    if (!pass.isEmpty()) {
        try {
            upPass = Integer.parseInt(pass);
            System.out.println(upPass);
            //Validate upPass for the combination of numbers
        } catch (NumberFormatException e) {
            throw e;
        }
    }
}