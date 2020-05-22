//Create an array with an integer for all the different faces
int[] amount = new int[face.length];

//set all those values to 0
for(int i = 0; i < amount.length;i++) amount[i] = 0;

//loop through the five cards
for(int i = 0; i < cardsPerPlayer;i++) {

    //setting the faceIndex to 0, which will later be used to see what face it is (so if its a 2 it will have face 0, just like the array
    int faceIndex = 0;

    //looping through all the faces
    for(int j = 0; j < face.length;j++)  {

        //detecting if the jth item in the face array matches the first character of the current card
        if(face[j].equals(Character.toString(deck[i].charAt(0)))) {
            //make the faceIndex that number
            faceIndex = j;
        }
    }

    //so now faceIndex is the index of the face in the array
    //so if the face is 2, faceIndex is 0
    //if the face is K, the faceIndex is 11 etc.
    //we add one to that item in the amount array
    amount[faceIndex]++;
}
//now we know how much of each face is in the dealt cards
//looping through all the amounts of cards
for(int i = 0; i < amount.length; i++) {
    //if the amount of cards with the current face is 2, we have a pair! (which we print)
    if(amount[i] == 2) {
        System.out.println("You have a pair of " + face[i] + "s!");
    }
}