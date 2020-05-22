@Override
public void setDate(int month, int day, int year) {
    if (isValidDate(month, day, year)) {
        super.setDate(month, day, year);
    }
    else {
        throw new IllegalArgumentException("Invalid date");
    } 
}