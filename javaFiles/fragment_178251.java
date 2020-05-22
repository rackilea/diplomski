public class MyClassDao {

    private List<MyClass> data;

    [...] // parsing CSV file and add the entries to data list

    public List<MyClass> searchByTemp(int temp) {
         List<MyClass> result = new ArrayList<>();
         for (MyClass mc : data) {
             if (mc.getTemp().equals(temp)) {
                  result.add(mc);
             }
         }
         return result;
    }

    public List<MyClass> searchByAnyOtherValue(...) {
        [...]
    }
}