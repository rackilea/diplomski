public class Month{
    private static final String[] names = new String[]{"January", "February"... "December"};
    private int index;
    private String name;
    public Month(int index){
      this.index = index;
      name = names[index - 1];
    }
    public Month(String name){
      this.name = name;
      index = java.util.Arrays.asList(names).indexOf(name) + 1;
    }
    public int getIndex(){
      return index;
    }
    public String getName(){
      return name;
    }
    public Boolean equals(Month month){
      return this.name.equals(month.getName());
    }
}