//LENGTH IS SET TO 4
            int len = 4;

            //COUNTER
            int counter = 0;

            //LOCAL ARRAY WITH JUS 10 ELEMENTS
            String[] numArr = {"one","two","three","four","five","six","seven","eight","nine","ten"};       

            //RANDOM NUMBER IS GENERATED BETWEEN 1 AND 10
            Random randNum = new Random();      
            int curRandom = randNum.nextInt(9) + 0; //0 TO 9 || 1 TO 10

            //CHOICE ARRAY
            String[] choices = new String[ len ];   //LENGTH IS SET TO 4

            //DISPLAY CURRENTLY GENERATED RANDOM NUMBER
            System.out.println("Current Random Number: " + curRandom);
            System.out.println("-------------------------");

            if(curRandom > 5){
                int aux = curRandom;
                for(int i = 0;i<len;i++) {
                    choices[i] = numArr[aux];
                    aux--;
                }
            }
            else {
                int aux = curRandom;
                for(int i = 0;i<len;i++) {
                    choices[i] = numArr[aux];
                    aux++;
                }
            }


            //DISPLAY CHOICE ARRAY ELEMENTS FOR DUBUGGING
            for(int j = 0; j < choices.length; j++)
                System.out.println(choices[j]);