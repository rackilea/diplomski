import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Dispatch implements java.io.Serializable {
   private static final long serialVersionUID = 1L;
    private Integer dispatchId;

   /**
    * @return the dispatchId
    */
   public Integer getDispatchId() {
       return dispatchId;
   }

   /**
    * @param dispatchId
    *            the dispatchId to set
    */
   public void setDispatchId(Integer dispatchId) {
       this.dispatchId = dispatchId;
   }

   @Override
   public String toString() {
       // TODO Auto-generated method stub
       return ""+this.dispatchId;
   }
}