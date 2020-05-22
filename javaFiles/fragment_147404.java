int nextSpot = 0; //next spot to fill in array
while (still_getting_input) {
    if (supposed_to_insert) {
        if (nextSpot_in_valid_range)
            myArray[nextSpot++] = value_to_insert;
        else
            System.out.println("Invalid operation!"); //cannot insert.
    }
}