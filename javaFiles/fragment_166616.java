public interface IAdaptable {
    <T> T adaptAs(Class<T> clazz);
}
public interface IChargeAmerican { void chargePhoneInAmerica(); }
public interface IChargeEurope { void chargePhoneInEurope(); }

public class EuropeanSocket implements IAdaptable, IChargeEurope {
    public <T> T adaptAs(Class<T> clazz) {
        if (clazz.equals(IChargeAmerican.class)) {
            return new EuropeanSocketToAmericanSocketAdapter(this);
        }
        throw new RuntimeException("unknown");
    }

    public void chargePhoneInEurope() {
        ;
    }
}

public class AmericanSocket implements IChargeAmerican {
    public void chargePhoneInAmerica() {
         ;
    }
}

public class EuropeanSocketToAmericanSocketAdapter implements IChargeAmerican {
    private EuropeanSocket socket;
    public EuropeanSocketToAmericanSocketAdapter(EuropeanSocket socket) {
         this.socket = socket;
    }

    public void chargePhoneInAmerica() {
         socket.chargePhoneInEurope();
    }
}