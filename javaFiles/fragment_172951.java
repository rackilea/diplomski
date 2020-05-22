class Temperature implements Comparable<Temperature> {
    private double kelvinTemperature; // Kelvin is probably the better scale to store a temperature 
    public int compareTo(Temperature t) {
        if(t.kelvinTemperature > this.kelvinTemperature)
            return 1;
        else if (t.kelvinTemperature < this.kelvinTemperature)
            return -1;
        else
            return 0; 
    }
}