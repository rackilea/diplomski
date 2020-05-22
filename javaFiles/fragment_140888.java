public class Snowflake {
        Turtle turtle;
     //Create a Turtle object here since you'll use it in this class' methods.
        public Snowflake(){
            turtle  = new Turtle(0, 0, 60);
        }
        public static void main(String[] args) {
          //Get a reference to your SnowFlake object here and then use this part for
          //user interaction only
            SnowFlake flake = new Snowflake();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter S: ");
            int S = sc.nextInt();
            System.out.println("Enter N: ");
            int N = sc.nextInt();

        //Call your functions here with the parameter your users just entered

        }

          //These 2 methods belong to the SnowFlake class and so they need to be 
          //declared in its body
            public void snowflakepart(int S, int N) {
                int z = 1;
                if(N > 0) {
                    turtle.goForward(S);
                    if(N>1){
                        turtle.turnLeft(120.0);
                        while(z<=5){
                            snowflakepart(S/3, N-1);
                            turtle.turnRight(60.0);
                        turtle.turnRight(180.0);
                    turtle.turnLeft(180.0);
                    turtle.goForward(S);
                    turtle.turnRight(180.0);    
                    }
                }
                }
            }
            public void drawSnowflake(int S, int N) {    
                int y = 1;
                while(y <= 6){
                    snowflakepart(S,N);
                    turtle.turnLeft(60.0);

                }
            }
        }