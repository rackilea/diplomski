int[] nums = {2,3,6};
int[] numweights = {25, 45, 30}; //weight of each element above
int totalweight = 100;

public int SetRandom() {

    int[] weighednums = new int[totalweight]; //new array to hold "weighted" nums
    int currentfruit = 0;
    int place = 0;
    while (currentfruit < nums.length) { //step through each num[] element
        for (int i=0; i < numweights[currentfruit]; i++){
            weighednums[place] = nums[currentfruit];
            place++;
        }
        currentfruit++;
    }

    int randomnumber = (int) Math.floor(Math.random() * totalweight);
    System.out.println(weighednums[randomnumber] + " at " + randomnumber);
    return weighednums[randomnumber];
}