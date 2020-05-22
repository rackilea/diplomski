public class ObjectToMapTo
{

   private HashMap< Integer , SecAltIDGrp > hmPrivGrp = new HashMap< Integer,SecAltIDGrp >();

   public void setSecAltIDGrp(  HashMap< Integer , SecAltIDGrp > hmSecAltIDGrp)
   {
          this.hmPrivGrp = hmSecAltIDGrp;
   }
}