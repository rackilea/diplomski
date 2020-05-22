public static double getNumericGrade(String s){
    Grade g = Grade.valueOf(s.substring(0, 1));
    if(s.length() > 1){
        return g.getModifiedScore(s.charAt(1));
    }else {
        return g.score;
    }
}