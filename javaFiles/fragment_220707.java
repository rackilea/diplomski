Quick Code for you..


public static void decompress(String originalString)
{
        StringBuffer finalString = new StringBuffer();;
        char previouschar = originalString.charAt(0);
        for(int i=1; i < originalString.length(); i+=2){
                for(int j = 0 ; j< Integer.parseInt(""+originalString.charAt(i));j++) {
                    finalString.append(previouschar);
                }               
                if(i+1 < originalString.length())
                {
                    previouschar=originalString.charAt(i+1);
                }
        }
        System.out.println(finalString.toString());
}