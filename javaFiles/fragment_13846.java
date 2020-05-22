import java.util.ArrayList;

int [][]card = new int [5][5];
ArrayList<Integer> alreadyUsed = new ArrayList<Integer>();
boolean valid = false;

for(int row = 0; row < card.length; row++){
    int tmp = 0;
    while(!valid){
        tmp = (int)(Math.random()*15)+1;
        if(!alreadyUsed.contains(tmp)){
            valid = true;
            alreadyUsed.add(tmp);
        }
    }
    card[row][0]= tmp;
    valid = false;
}