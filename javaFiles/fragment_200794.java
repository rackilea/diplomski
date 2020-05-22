public static void main(String[] args) {

    double waterLevel, initialWaterLeve;
    waterLevel = 0;
    initialWaterLeve = 0;
    int count=0;
    Scanner sc = new Scanner(System.in);

    while (waterLevel > 0){
        System.out.println("What is the water level at now (in mm): ");
        waterLevel = sc.nextDouble();
        if (waterLevel < initialWaterLevel){
              count++;
        }
        else{
              count=0;
        }

        if(count>=3){
            System.out.println("It appears that the flood is subsiding.");
            break; // if you want to come out of loop.
        }
        initialWaterLevel = waterLevel;
    }
}