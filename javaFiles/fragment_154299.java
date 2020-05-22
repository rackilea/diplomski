public class BasicAccount extends Account{
    public void doSomethingAccountLike(){
        //implementation specific to basic accounts
    }
}

public class PremiumAccount extends Account{
    public void doSomethingAccountLike(){
        //implementation specific to premium accounts
    }

    public void doSomethingPremiumLike(){
        //something that only makes sense
        // in the context of a premium account
    }
}