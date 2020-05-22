import com.dsi.business.SSA_YU.integration.jdo.P_YUCCS00.C_YUCCS00;

public class C_YUCCProxy {
    private  C_YUCCS00 underlying;

    //First example of constructor if new objects are created
    public C_YUCCProxy() {
         this.underlying = new C_YUCCS00();
    }

    //Second example using existing object
    public C_YUCCProxy(C_YUCCS00 object) {
         this.underlying = object;
    }

    public void doLogic(int value) {
        underlying.doLogic(value);
    }

    public String getStringValue() {
        return underlying.getStringValue();
    }
    //... all other public methods
}