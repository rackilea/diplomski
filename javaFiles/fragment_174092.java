import java.util.Map;
import java.util.HashMap;


public class Test {
    boolean isWriteLockTaken;
    Map<Integer,String> cachedUsers = new HashMap<Integer,String>();  

    public static void main(String[] args) throws Exception {
        Test t = new Test();
        for(int i=0;i<10;i++){
            t.updateAndGetUser(1);
        }
    }

    public String updateAndGetUser(Integer id) throws InterruptedException {
        if(isWriteLockTaken && !cachedUsers.containsKey(id)){
            this.wait();
        }

        if(!cachedUsers.containsKey(id)){
            isWriteLockTaken = true;
            synchronized(id){
                if(id==1){
                    // do processing to retrive user
                    System.out.println("Updating & loading user");
                    cachedUsers.put(id, "Gaurav");
                    return "Gaurav";
                }
            }
            isWriteLockTaken = false;
        }
        System.out.println("returning from cached list, not loading user details as it is already loaded");
        return cachedUsers.get(id);
    }

}