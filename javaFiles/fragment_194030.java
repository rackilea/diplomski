class ConcertSales{
    public int numberOfSeatTypesA;
    public int numberOfSeatTypesB;
    public double pricePerSeatA;
    public double pricePerSeatB;
    public double totalSales; 

    public int getNumberOfSeatTypesA(){ 
        return numberOfSeatTypesA;
    }

    public void setNumberOfSeatTypesA(int newValue){ 
        numberOfSeatTypesA = newValue; 
    }

    public double computeTotalSales(){ 
        return totalSales = numberOfSeatTypesA*pricePerSeatA +
                   numberOfSeatTypesB*pricePerSeatB;
    }

    public static void main(String[] args) {
        ConcertSales concertSales = new ConcertSales();
        concertSales.setNumberOfSeatTypesA(30); 
        System.out.println(concertSales.getNumberOfSeatTypesA());
    }
}