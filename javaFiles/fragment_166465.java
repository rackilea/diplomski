public HashMap< Integer , SecAltIDGrp > populateComments( int NoComments )
{
    HashMap< Integer , SecAltIDGrp > hmSec = new HashMap< Integer , SecAltIDGrp >();
    for(int i; i < NoComments; i++)
    {
          SecAltIDGrp x = new SecAltIDGrp();

          x.setAltID(obj.getVal);
          x.setAltIDSource(arg0, arg1);

          hmSec.put( i , x );
    }

    return hmSec;
}

public class SecAltIDGrp{
   String altId = "";
   String altIdSource = "";

   public void setAltIDSource(  String altIDSource )
   {
       this.altIdSource = altIDSource;
   }

   public void setAltID( String altId )
   {
        this.altId = altID;
   }
}