public abstract class GenericService {   
    SoaConfig soaConfig;
    public GenericService(SoaConfig soaConfig) {
       System.out.println("----- hi-----"+soaConfig);
    }
}

public class SSI extends GenericService {
   public SSI(SoaConfig soaConfig) {
      super(soaConfig);
      System.out.println("---- SSI ----");
   }
}