enum BloodType {
    A_MINUS("A+", 1), 
    B_PLUS("B+", 2), 
    B_MINUS("B-", 3), 
    O_PLUS("AO", 4), 
    O_MINUS("O-", 5), 
    AB_PLUS("AB+", 6), 
    AB_MINUS("AB-", 7);

    BloodType(String value, int code) {
        this.value = value;
        this.code = code;
    }

    String value;
    int code;

}

void getBloodInformation(BloodType type) {
    switch (type) {
    case A_MINUS:
        // do something ...
        break;
    case O_MINUS:
        // do other things
        break;
    default:
        // default behavior if you didn't define all cases above
    }
}