public static void main(String[] args) {
    // only mandatory params
    Airplane boeing747  = new Airplane.Builder(new int[] {1,0,1}, "boeing747").build();
    // just one param
    Airplane boeing646  = new Airplane.Builder(new int[] {1,1,1}, "boeing646").maxPassengers(250).build();
    // all params
    Airplane fighter    = new Airplane.Builder(new int[] {1,0,0}, "fighter_1").maxPassengers(3).maxSpeed(1600).build();
}