public void setCelsius(double celsius){
        this.celsius = celsius;
    }

    public void setFahrenheit(double fahr){
        this.celsius = (fahr -32)*5/9;
    }

    public double getFahrenheit(){
        return this.celsius*9/5+32;
    }


    public double getCelsius(){
        return this.celsius;
    }