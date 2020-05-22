public class NameSorter implements Comparator<Product>{

        public int compare(Product one, Product another){
            return one.getName().compareTo(another.getName());
        }
}