public class FindRouteOutputForDisplay implements Serializable{
   public ArrayList<VertexDisplay> vertexDisplayArrayList;
   public ArrayList<Integer> integerArrayList;
}

Intent newIntent = new Intent(FirstActivity.this, SecondActivity.class);
FindRouteOutputForDisplay data = getMyData();
newIntent.putSerializable("data", data); 
startActivity(newIntent);