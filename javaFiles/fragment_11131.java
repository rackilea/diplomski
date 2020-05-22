public class ModuleInfo implements Comparable<ModuleInfo> {

    /* Your implementation */

    public int compareTo(ModuleInfo info) {
        if (this.dateDue < info.dateDue) {
            return -1;
        } else if (this.dateDue > info.dateDue) {
            return 1;
        } else {
            return 0;
        }
    }
}