import java.util.List;

import org.apache.commons.collections.CollectionUtils;


public class Test {

    boolean someCriteria = false;

    public static void main(String[] args) {
        System.out.println(new Test().getFirstElement());
    }


    public List<Object> getList() {

        List<Object> list = new ArrayList<Object>();
        if (someCriteria) {
            list.add("1");
        }
        return list;
    }


        public Object getFirstElement() {
            List<Object> list = getList();
            if (!CollectionUtils.isEmpty(list))
                return list.get(0);
            return null;
        }   
}