class RemovalThread extends Thread {
static Set<Integer> originalBigSet = new HashSet<>();
@Override
public void run() {
    System.out.println("RemovalThread started");
    while (true) {
        try {
            sleep(1000);
            System.out.println("creating copy of originalBigSet");
            Set<Integer> tempList;
            synchronized (HashSetTest.obj) {
                tempList = new HashSet<>(originalBigSet);
            }
            System.out.println("copied list");
            //
            //some operations on copied temp list
            //
            System.out.println("removing tempList elements after completing operations");
            System.out.println("originalBigSet before removing size " + originalBigSet.size());
            synchronized (HashSetTest.obj) {
                originalBigSet.removeAll(tempList);
            }
            System.out.println("removed!!");
            System.out.println("after size " + originalBigSet.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}