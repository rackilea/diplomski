public class MyEntryProcessor extends AbstractProcessor  implements PortableObject {

 @Override
 public Object process(Entry myEntry) {     

    ((BinaryEntry)myEntry).expire(100);
    return myEntry;
 }
}