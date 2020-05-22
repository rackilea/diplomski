/**
   <P>{@code java RawNumericValueOfChar}</P>
 **/
public class RawNumericValueOfChar  {
   public static final void main(String[] ignored)  {
      int intValueOfCharOne = '1';
      int intValueOfCharALower = 'a';
      int intValueOfCharAUpper = 'A';

      System.out.println("intValueOfCharOne=" + intValueOfCharOne);
      System.out.println("intValueOfCharALower=" + intValueOfCharALower);
      System.out.println("intValueOfCharAUpper=" + intValueOfCharAUpper);

      int intValueOfCharOneInc = ((int)'1') + 1;
      int intValueOfCharALowerInc = ((int)'a') + 1;
      int intValueOfCharAUpperInc = ((int)'A') + 1;

      System.out.println("intValueOfCharOneInc=" + intValueOfCharOneInc);
      System.out.println("intValueOfCharALowerInc=" + intValueOfCharALowerInc);
      System.out.println("intValueOfCharAUpperInc=" + intValueOfCharAUpperInc);

   }
}