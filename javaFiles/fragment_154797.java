public class NameClass{

  public String getValues() throws Exception 
  {
            HelpingClass e= getHelpingClass();
            ....
  }

  HelpingClass getHelpingClass(){
      return new HelpingClass();
  }
}