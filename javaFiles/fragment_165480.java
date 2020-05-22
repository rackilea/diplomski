// potentialParent would probably just be Thread.currentThread();
public static boolean isChild(Thread potentialChild, Thread potentialParent) {
    try {
        return potentialParent.getThreadGroup().parentOf(potentialChild.getThreadGroup());
    }catch(NullPointerException e) {
        e.printStackTrace();            
    }
    return false;
}