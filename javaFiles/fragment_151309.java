public class MixProcessor {
    private static int counter = 0;

    public static void main(String[] args) {
        String str= "Wx1 Wx2 Wy1 Wx3 Wx4 Wy2 Wx5 Wx7 Wx8";
        StringBuilder output = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        String previousPatter = "";
        boolean shouldMerge = false;

        for(String s : str.split(" ")){
            String processedString = "";

            if (s.matches(".*?x.*")){
                shouldMerge = ("x".equals(previousPatter) || previousPatter.trim().length() == 0) ? true : false;
                previousPatter = "x";
                processedString = function1(s);
            } else if (s.matches(".*?y.*")){
                shouldMerge = ("y".equals(previousPatter) || previousPatter.trim().length() == 0) ? true : false;
                previousPatter = "y";
                processedString = function2(s);
            }

            if(shouldMerge){
                temp.append(processedString);
            } else {
                output.append(function3(temp.toString()));
                temp = new StringBuilder(processedString);
            }
        }
        //Append the last value
        output.append(function3(temp.toString()));

        System.out.println(output.toString());
    }

    private static String function2(String s) {
        return "Y" + s.substring(s.indexOf("y") + 1);
    }

    private static String function1(String s) {
        return "S" + s.substring(s.indexOf("x") + 1);
    }

    private static String function3(String s) {
        // Here this could be any function. I'm just trying to make as per the question
        return (s.indexOf("S") != -1) ? ("str" + (++counter)) : s;
    }

}