public class Car {

    protected String regNum;

    protected Car(String regNum) {
        this.regNum = regNum;
    }
}

public class GasCar extends Car {

    protected double gasEmissions;

    protected GasCar(String regNum, double gE) {
        super(regNum);
        gasEmissions = gE;
    }
}