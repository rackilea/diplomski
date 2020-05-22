/**
 * Different manufacturers can extend this interface
 * to ensure compile-time compatibility of their products while
 * using standard APIs that use generics for type safety. 
 */
public interface Manufacturer {

}

/**
 * This interface marks products created by Samsung.
 */
public interface Samsung extends Manufacturer {

}

/**
 * This interface marks products created by Sony.
 */
public interface Sony extends Manufacturer {

}

public abstract class Television<M extends Manufacturer>{
    private int channel;

    //this ensures that a television only makes a remote
    //by the same manufacturer
    public abstract Remote<M> makeRemote();

    public int getChannel(){
        return channel;
    }

    public void setChannel(int c){
        channel=c;  
    }
}

public class SamsungTelevision extends Television<Samsung>{
    private int channel;

    public Remote<Samsung> makeRemote(){
        return new SamsungRemote();
    }   

}


public class SonyTelevision extends Television<Sony>{
    private int channel;

    public Remote<Sony> makeRemote(){
        return new SonyRemote();
    }

}


public abstract class Remote<M extends Manufacturer>{

    //this ensures that a remote only works with a remote
    //by the same manufacturer
    public abstract void changeChannel(Television<M> t,int channel);
}


public class SamsungRemote extends Remote<Samsung>{

    public void changeChannel(Television<Samsung> t,int channel){
        t.setChannel(channel);
        System.out.println("Samsung: Channel has been switched");
    }

}


public class SonyRemote extends Remote<Sony>{

    public void changeChannel(Television<Sony> t,int channel){
        t.setChannel(channel);
        System.out.println("Sony: Channel has been switched");
    }
}

public class Driver{
    public static void main(String[] args){
        Television<Samsung> t = new SamsungTelevision();
        Television<Sony> t1 = new SonyTelevision();
        Remote<Samsung> r=t.makeRemote();
        r.changeChannel(t,35);
        System.out.println("Samsung current channel: " + t.getChannel());

        //generates a compile time error because r is a samsung remote and
        //t1 is a Sony TV
        //r.changeChannel(t1,37);
        //System.out.println("Sony current channel: " + t1.getChannel());
    }
}