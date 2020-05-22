public interface XMLWritable {
  void writeToXml(); 
}

public class HouseGUI implements XMLWritable {
   public void writeToXml() {
     //XML writing stuff
   }

}

----
for (int i = 0; i < totalTabs; i++) {
 if(tabbedPane.getComponentAt(i) instanceof XMLWritable ) {
   ((XMLWritable) tabbedPane.getComponentAt(i)).writeToXml();
 }
}