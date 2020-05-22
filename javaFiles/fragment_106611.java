public class Select extends Sort{

public Select(int[] lst) {
    super(lst);
}


public void sort() {
    for (int i = 0; i < this.lst.length; i++) {
        int small = lst[i];
        int small_ind = i;
        for (int j = i + 1; j < this.lst.length; j++) {
            if (lst[j] < small) {
                small = lst[j];
                small_ind = j;
            }
        }
        int temp = lst[i];
        lst[i] = small;
        lst[small_ind] = temp;
    }
}
}