enum Locations
{
    FrontDoor, LivingRoom, DiningRoom, Stairs, Bedroom1, Bedroom2, MasterBedroom, Kitchen, Pantry, Bathroom, ExploreLivingRoomItems,

    // add a .toString() for each place
}



private static String getPlayer()
{
    JFormattedTextField nameField = new JFormattedTextField();

    /* New JPanel */
    JPanel myPanel = new JPanel();
    myPanel.add(new JLabel("Enter your name to play: "));
    myPanel.add(nameField);
    myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));

    int result = JOptionPane.showConfirmDialog(null,
                                               myPanel,
                                               "Enter Name",
                                               JOptionPane.OK_CANCEL_OPTION);


    if (result == JOptionPane.OK_OPTION) {
        return nameField.getText();
    }
    else {
        return "";
    }
}



private static void showMap()
{
    // show the map
}



private static Locations getAction(String playerName, Locations[] locations)
{
    Object[] opts = new Object[locations.length];
    for (int i = 0; i < opts.length; ++i) {
        opts[i] = locations[i].toString();
    }

    int res = JOptionPane.showOptionDialog(null,
                                           "Select your next move, "
                                                   + playerName,
                                           "Haunted House",
                                           JOptionPane.YES_NO_OPTION,
                                           JOptionPane.INFORMATION_MESSAGE,
                                           null,
                                           opts,
                                           opts[0]);

    return locations[res];
}



private static Locations getFrontDoor(String playerName)
{
    Locations[] locs = { Locations.LivingRoom, Locations.DiningRoom,
            Locations.Stairs };

    return getAction(playerName,
                     locs);
}



private static Locations getLivingRoom(String playerName)
{
    Locations[] locs = { Locations.Bathroom, Locations.ExploreLivingRoomItems };
    return getAction(playerName,
                     locs);
}



public static void main(String[] args)
{
    Locations loc = Locations.FrontDoor;


    final String playerName = getPlayer();
    showMap();


    boolean keepGoing = true;

    while (keepGoing) {

        switch (loc) {
        case FrontDoor:
            loc = getFrontDoor(playerName);
            break;

        case LivingRoom:
            loc = getLivingRoom(playerName);
            break;

        // all other rooms
        } // switch
    }


}