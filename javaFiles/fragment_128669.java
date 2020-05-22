public airplane(int num_of_seats)
{
    seats = new boolean[num_of_seats];
    for (int counter = 0; counter < num_of_seats; counter++)
    {
        seats[counter] = true;
    }
}