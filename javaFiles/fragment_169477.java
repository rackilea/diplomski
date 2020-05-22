public class MergSort {

    public List mergSort(List list) {
        Divide divide = new Divide();
        Merg merg = new Merg();
        int n = list.getLength();
        if (n > 1) {
//            return merg.Merg(mergSort(divide.leftSide(list)), mergSort(divide.rightSide(list)));
            Link cursor = list.head.next;
            List left = new List();
            List right = new List();
            // for (i = 0; ....... i will be 0 if head is not dummy
            for (int i = 1; cursor != null; i++) {
                if (i <= n/2)
                    left.Insert(cursor.data);
                else
                    right.Insert(cursor.data);
                cursor = cursor.next;
            }
            left = mergSort(left);
            right = mergSort(right);

            return merg.Merg(left, right);

        } else {
            return list;
        }
    }
}