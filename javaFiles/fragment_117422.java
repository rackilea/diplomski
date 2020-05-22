public class Counter {
    .......
    public static Counter createFor(String descriptor){
        String[] params = descriptor.split(":");
        return new Counter(params[0], params[1], params[2]);
    } 
}