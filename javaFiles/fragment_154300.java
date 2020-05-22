public class AccountDemo{
    public static void main(String[] args){
        PremiumAccount premium = new PremiumAccount();
        BasicAccount basic = new BasicAccount();
        Account generalAccount = premium;

        //valid- the compiler knows that the
        //premium object is an instance of the
        //premium class
        premium.doSomethingPremiumLike();

        //Would cause a compile error if uncommented.
        //The compiler knows that basic is an instance
        //of a BasicAccount, for which the method
        //doSomethingPremiumLike() is undefined.
        //basic.doSomethingPremiumLike();

        //Would generate a compiler error if uncommented.
        //Even though generalAccount actually refers to
        //an object which is specifically a PremiumAccount,
        //the compiler only knows that it has a reference to
        //an Account object, it doesn't know that it's actually
        //specifically a PremiumAccount. Since the method
        // doSomethingPremiumLike() is not defined for a general
        //Account, this won't compile
        //generalAccount.doSomethingPremiumLike();

        //All compile- all are instances of Account
        //objects, and the method doSomethingAccountLike()
        //is defined for all accounts.
        basic.doSomethingAccountLike();
        premium.doSomethingAccountLike();
        generalAccount.doSomethingAccountLike();
    }
}