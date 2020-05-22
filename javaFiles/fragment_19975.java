public class CallRetConfig {
    public static void callerMethod(){
        RetConfig retConfig = new RetConfig();
        retConfig.retConfig();
        System.out.println(" print in second class : "+retConfig.urlValue);
    }   
    public static void main(String[] args) {
        callerMethod();
    }
}