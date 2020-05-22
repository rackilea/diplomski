public class SingleLengthCriteria implements XsamCriteria {

private final FilterLength filterLength;
private final Function<XsamRecord, Interger> propertyValueGetter;

public SingleLengthCriteria(FilterLength filterLength, Function<XsamRecord, Interger> propertyValueGetter)  {
  this.filterLength = filterLength;
  this.propertyValueGetter = propertyValueGetter;
}

@Override
public List<XsamRecord> meetRecordCriteria(List<XsamRecord> records) {
  List<XsamRecord> spanLengthRecords = new ArrayList<>();

  for(XsamRecord record : records){
    final Integer value = propertyValueGetter.apply(record);
    if(value >= filterLength.getMin() && value <= filterLength.getMax()){
    spanLengthRecords.add(record);
    }
  }

  return spanLengthRecords;
}