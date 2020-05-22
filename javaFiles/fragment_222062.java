public static void main(String[] args)
{
    for(int i = 0; i < [NumberOfRepeats]; i++)
    {
        lottery pic=new lottery();
        pic.Get_player_numbers();
        pic.Get_jackpot_number();
        pic.Check_winner ();
        pic.Write_data();
    }
}