public static void main(String[] args) throws Exception
{
   String input = "the current time is <start time>00:00:00<end time>. at 00:00:00 there is a firework. Another appearance of 00:00:00.";
   String result = input.replaceAll("(?<!<start time>)00:00:00(?!<end time>)", "<start time>00:00:00<end time>"); 
   // Negative lookbehind -----------^^^^^^^^^^^^^^^^^        ^^^^^^^^^^^^^^
   // Negative lookahead ------------------------------------/
   System.out.println(result);
}