public boolean serve(int s, int n, Scoop scoop) {

    Scanner input = new Scanner(System.in);

    Carton carton = new Carton();
    int i = 0;
    //Checks which scoop the is being used
    if(s != 0) {
        double scoopVolume = scoop.doScoop(1)