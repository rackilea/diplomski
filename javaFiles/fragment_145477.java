String oldValue = "";
while (true)
{
    String player=json_obj.getString("username");
    if (!oldValue.equals(player))
    {
        System.out.println("Found Player "+player);
        break; // quit loop when player found?
    }
    oldValue = player
}