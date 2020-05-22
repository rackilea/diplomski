int diff = 0;
int firstNum = temp[0];
int lastNum = temp[0];
for (int j=0; j < temp.length - 1; j++){
    if (temp[j] != -1){

        diff = Math.abs(temp[j] - temp[j+1]);

        if (diff <= 1){
            // last number
            lastNum = temp[j+1];
        }
        else {
            System.out.println("First number: " + firstNum + ", last number: " + lastNum);
            firstNum = temp[j+1];
            lastNum = temp[j+1];
        }

    }
}