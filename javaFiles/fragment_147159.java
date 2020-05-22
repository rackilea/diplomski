public void initialPairs() {

    for (int index1 = hand.getSize(); index1 > 0; index1--) {

        for (int index = 0; index < index1; index++) {

            if (hand.get(index1).getRank() == hand.get(index).getRank()) 
            {
                Card c = hand.remove(index1);
                Card d = hand.remove(index);
                size = size - 2;
                --index1; // adjust for removal of element at position index
                System.out.println("Removed: " + c + " & " + d);
                System.out.println("Player 1's hand:" + hand);
                break;
            }
        }
    }

}