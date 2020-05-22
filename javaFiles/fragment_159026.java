package practice;

public class Try {

    public static void main(String[] args) {

        String[] names = {"Person", "Human", "Man", "Woman"};
        String[] adress = {"Hole", "Street", "Attic", "Room"};
        int[] money = {25, 0, 12, 13};

        for(int first = 0; first < 4; first++){
            int most = first;
            for(int current = first + 1; current < 4; current++){
                if (money[current] > money[most]){
                    most = current;
                }
                int temp = money[most];
                money[most] = money[first];
                money[first] = temp;

                String tempString = names[most];
                names[most] = names[first];
                names[first] = tempString;

                tempString = adress[most];
                adress[most] = adress[first];
                adress[first] = tempString;
            }
        }

        for (int i = 0; i < 4; i++){
            System.out.println(names[i]);
            System.out.println(adress[i]);
            System.out.println(money[i]);
        }
    }
}