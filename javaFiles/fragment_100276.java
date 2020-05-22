import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BasicModel {
   private float value;

   public float getValue(){
       return value;
   }

   public float setValue(float value){
       this.value = value;
   }

}