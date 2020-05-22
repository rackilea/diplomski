public class TestCode {
    public static String s1 = "team A won the match historically to clinch series which made surprise around the world ";
     public static String s2 = "He did his part";
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
         ArrayList<String> Sub_string = new ArrayList<String>();  

        int t1=s1.length();
        int t2=s2.length();
        int t3=Math.abs(t1-t2); 


        try {
            for(int i=0;i<t3;i++)
              {
                  Sub_string.add(s1.substring(i,t2++));
              }
        } catch (Exception e) {
            System.err.println();

        }

    }

}