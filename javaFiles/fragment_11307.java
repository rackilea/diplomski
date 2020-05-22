public class Match{
    public static void main(String[] args){
        String anchorGuyField = "asdasda-15.56757-asdasd";

        if(!anchorGuyField.matches("(-?\\d+(\\.\\d+)?)")){ //match integer or double
            Pattern pattern = Pattern.compile("(-?\\d+(\\.\\d+)?)");
            Matcher matcher = pattern.matcher(anchorGuyField);
            if(matcher.find()){
            anchorGuyField = anchorGuyField.substring(matcher.start(),matcher.end());
            }
        }
        System.out.println(anchorGuyField);
    }
}