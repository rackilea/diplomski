private Random random= new Random();

private float inttt = 0;

private float tiempo = 0;

private int randomT = 0;

private int randomN = 0;

private final int MAXTIEMPO = 15; // cambiar para aumentar o disminuir el tiempo que pasa como maximo entre un movimiento y otro.//changed to increase or decrease the time spent at most from one movement to another.

public int RandomNumber(float delta){

    tiempo += delta;

        if(randomT == 0 || randomN == 0){

                random.setSeed(System.nanoTime() * (long)inttt);
                this.randomN = random.nextInt(MAXTIEMPO);
                inttt += randomN;
                randomT = randomN;

                Gdx.app.log("randomN", ""+randomN);
                Gdx.app.log("randomT", ""+randomT);
                Gdx.app.log("tiempo", ""+tiempo);

                return 0;

        }else if(randomT != 0 && tiempo >= randomT){

                tiempo = 0;
                randomT = 0;

                Gdx.app.log("randomN", ""+randomN);
                Gdx.app.log("randomT", ""+randomT);
                Gdx.app.log("tiempo", ""+tiempo);

                return randomN;

        }else{

                Gdx.app.log("randomN", ""+randomN);
                Gdx.app.log("randomT", ""+randomT);
                Gdx.app.log("tiempo", ""+tiempo);

                return 0;
        }
    }