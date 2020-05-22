public static Component centerPanel(Component panelToBeCentered)
{
    JPanel vertical = ...
    vertical.add( panelToBeCentered );

    JPanel horizontal = ...
    horizontal.add( vertical );

    return horizontal;
}