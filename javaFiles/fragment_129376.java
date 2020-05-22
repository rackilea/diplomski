public static String getAlignedHeader(int maxLength){
    // returns the header of the ressult
    String tmpStrg = " STUDENT FULLNAME  ";
    int currentLength = tmpStrg.length();
    for(int i = 0; i < (maxLength-currentLength); i++){
        tmpStrg+=" ";
    }
    return "STUDENTID \r  \t"+tmpStrg+"\r\tENGLISH \t MATH \t SOCIAL \t SCIENCE "+ "\tTOTAL \t AVERAGE  \t POSITIONS\n";
}