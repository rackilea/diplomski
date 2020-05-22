public class RandomAccessSubListConverter extends CollectionConverter {

public RandomAccessSubListConverter(Mapper mapper) {
    super(mapper); 
} 

@Override
public boolean canConvert(Class arg0) {     
    return arg0.getName().equals("java.util.RandomAccessSubList");
}

@Override
public Object unmarshal(HierarchicalStreamReader reader,
        UnmarshallingContext context) {        
    reader.moveDown();
    ArrayList arrayList = new ArrayList();
    populateCollection(reader, context, arrayList);
    reader.moveUp();
    return arrayList;
}