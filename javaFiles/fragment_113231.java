public enum EmergencyPriority {
    P1(BusinessCriticality.C1, EmergencyLevel.E1), 
    P2(BusinessCriticality.C1, EmergencyLevel.E2, 
       BusinessCriticality.C2, EmergencyLevel.E1), 
    P3(BusinessCriticality.C1, EmergencyLevel.E3, 
       BusinessCriticality.C2, EmergencyLevel.E2), 
    P4(BusinessCriticality.C2, EmergencyLevel.E3, 
       BusinessCriticality.C3, EmergencyLevel.E1), 
    P5(BusinessCriticality.C3, EmergencyLevel.E2), 
    P6(BusinessCriticality.C3, EmergencyLevel.E3, 
       BusinessCriticality.C4, EmergencyLevel.E1), 
    P7(BusinessCriticality.C4, EmergencyLevel.E2), 
    P8(BusinessCriticality.C4, EmergencyLevel.E3);

    private static EmergencyPriority[][] PRIORITIES;

    private EmergencyPriority(BusinessCriticality c, EmergencyLevel l) {
        addPriority(l, c, this);
    }

    private EmergencyPriority(BusinessCriticality c, EmergencyLevel l, 
            BusinessCriticality c2, EmergencyLevel l2) {
        addPriority(l, c, this);
        addPriority(l2, c2, this);
    }

    private static void addPriority(EmergencyLevel l, BusinessCriticality c, EmergencyPriority p) {
        if (PRIORITIES == null) {
            PRIORITIES = new EmergencyPriority[EmergencyLevel.values().length][BusinessCriticality.values().length];
        }
        PRIORITIES[l.ordinal()][c.ordinal()] = p;
    }

    public static EmergencyPriority of(BusinessCriticality c, EmergencyLevel l) {
        return PRIORITIES[l.ordinal()][c.ordinal()];
    }
}