import static com.package.BusinessCriticality.*;
import static com.package.EmergencyLevel.*;

public enum EmergencyPriority {
    P1, P2, P3, P4, P5, P6, P7, P8;

    private static EmergencyPriority[][] PRIORITIES = new EmergencyPriority[BusinessCriticality.values().length][EmergencyLevel.values().length];

    private void define(BusinessCriticality c, EmergencyLevel e) {
        PRIORITIES[c.ordinal()][e.ordinal()] = this;
    }

    static {
        P1.define(C1, E1);

        P2.define(C1, E2);
        P2.define(C2, E1);

        P3.define(C1, E3);
        P3.define(C2, E2);

        P4.define(C2, E3);
        P4.define(C3, E1);

        P5.define(C3, E2);

        P6.define(C3, E3);
        P6.define(C4, E1);

        P7.define(C4, E2);

        P8.define(C4, E3);
    }

    public static EmergencyPriority of(BusinessCriticality c, EmergencyLevel e) {
        return PRIORITIES[c.ordinal()][e.ordinal()];
    }
}