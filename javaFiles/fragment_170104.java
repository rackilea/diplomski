public class ComparatorTest{
     public static void main(String[] ar) {
        // System.out.println(new Sample().stringTimes("vivek", 5));
        JSONObject emp1 = new JSONObject();
        JSONObject emp2 = new JSONObject();
        try {
            emp1.put("department", "IT");
            emp1.put("name", "bvivek");
            emp1.put("id", 1);

            emp2.put("department", "IT");
            emp2.put("name", "avikash");
            emp2.put("id", 2);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<JSONObject> employess = new ArrayList<JSONObject>();
        employess.add(emp1);//add to list
        employess.add(emp2);//add to list
        System.out.println(employess);//unsorted, as is
        Collections.sort(employess, new JSONComparator("name"));
        System.out.println(employess);//sorted as per the field
        //using treeSet
        TreeSet<JSONObject> jsonInTree = new TreeSet<JSONObject>(new JSONComparator("id"));
        jsonInTree.addAll(employess);
        System.out.println(jsonInTree);//using the tree implementation
    }
}