// DefaultBusinessman.java
public class DefaultBusinessman implements Businessman {
    @Override
    public void workHard() {
    }
}

// CTO.java
public class CTO extends DefaultBusinessman {
    // CTO does no longer need to be abstract, as the implementation of doWork is provided
    // through inheritance
}