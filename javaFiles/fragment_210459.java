public class UsedCar extends Car {

    private double mileage;
    private String color = "silver";

    public UsedCar(String color, double price, double mileage) {
        super(color, price);
        this.mileage = mileage;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        long temp;
        temp = Double.doubleToLongBits(mileage);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        UsedCar other = (UsedCar) obj;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (Double.doubleToLongBits(mileage) != Double.doubleToLongBits(other.mileage))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "\nType: Used\nMileage: " + mileage + "\n";
    }

}