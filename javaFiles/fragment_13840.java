public class Player 
{
    public Player(String class)
    {
        switch (class)
        {
            case "Barbarian": 
                Barbar();
                break;
        }
    }

    public void Barbar()
    {
        HP = 60;
        ATK = 15;
        DEF = 25;
        setDAMAGE();
    }
}