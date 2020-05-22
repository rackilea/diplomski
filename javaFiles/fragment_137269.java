public class BagUdf extends EvalFunc<DataBag> {

public <returnType> exec(Tuple input) throws IOException {
//iterate over the bag elements
for (Tuple t : (DataBag)input.get(0)) {
     // process tuple t
}
return returnVal;
}