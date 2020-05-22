class thisApp {
    /* Some initial processing creates an ArrayList - aList */

    Runnable proExec = new ProcessList (aList);
    Thread th = new Thread(proExec);
}

public class ProcessList implements Runnable {
    private final ArrayList<Character> aList;
    public ProcessList(ArrayList<Character> aList) {
      this.aList = aList;
    }
    public void run() {
      /* use this.aList */
    }
}