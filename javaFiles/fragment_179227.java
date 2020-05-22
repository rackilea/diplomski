import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String args[]) {
        String arrId[] = { "India", "England", "France", "China", "India", "France", "India", "England", "Germany" };
        List<String> mList2 = Arrays.asList(arrId);
        List<List<String>> output = new ArrayList<List<String>>();
        List<String> itemsAlreadyGrouped = new ArrayList<String>();
        for (int i = 0; i < mList2.size(); i++) {
            List<String> groupList = new ArrayList<String>();
            boolean groupCandidateFound = false;
            if (!itemsAlreadyGrouped.contains(mList2.get(i))) {
                for (int j = 0; j < mList2.size(); j++) {
                    if (mList2.get(i).equals(mList2.get(j))) {
                        groupList.add(mList2.get(i));
                        groupCandidateFound = true;
                    }
                }
                if (groupCandidateFound) {
                    itemsAlreadyGrouped.add(mList2.get(i));
                }
            }
            if (groupList.size() > 0) {             
                output.add(groupList);
            }
        }

        //Let's test the logic
        for (List<String> group : output) {
            System.out.println(group);
        }
    }
}