class Convertor{

    private static final double KG_TO_GRAM = 1000, LBS_TO_GRAM = 453.592;

    private double value;
    public Convertor(double value) {
        this.value = value;
    }

    Convertor kgToGr(){
        value *= KG_TO_GRAM;
        return this;
    }

    Convertor grToKg(){
        value /= KG_TO_GRAM;
        return this;
    }

    Convertor lbToGr(){
        value /= LBS_TO_GRAM;
        return this;
    }

    Convertor grToLb(){
        value /= LBS_TO_GRAM;
        return this;
    }

    double getValue() {return value;}
}