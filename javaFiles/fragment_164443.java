private void tripleDraw (int n1, int n2, int d) 
{
    for (int i = 0; i < n1; i++)
    { 
        dayButtons [i] = new JButton (""); 
        P3.add (dayButtons [i]);
        dayButtons [i].setBackground (Color.LIGHT_GRAY);
    } 
    for (int i = n1; i < n2; i++)
    {
        dayButtons [i] = new JButton (i+d + ""); 
        P3.add (dayButtons [i]);
        dayButtons [i].setBackground (c2);
    } 
    for (int i = n2; i < 49; i++)
    { 
        dayButtons [i] = new JButton (""); 
        P3.add (dayButtons [i]);
        dayButtons [i].setBackground (Color.LIGHT_GRAY);
    } 
}

private void DrawCalendar (int DayOfWeek, int year, int month) 
{
    P3.setLayout (new GridLayout (7, 7, 3, 3));
    dayButtons = new JButton [49];

    if (DayOfWeek == 1 && ch == 1)  tripleDraw (0, 31, 1);
    if (DayOfWeek == 2 && ch == 1)  tripleDraw (1, 32, 0);
    if (DayOfWeek == 3 && ch == 1)  tripleDraw (2, 33, -1);
    if (DayOfWeek == 4 && ch == 1)  tripleDraw (3, 34, -2);
    if (DayOfWeek == 5 && ch == 1)  tripleDraw (4, 35, -3);
    if (DayOfWeek == 6 && ch == 1)  tripleDraw (5, 36, -4);
    if (DayOfWeek == 7 && ch == 1)  tripleDraw (6, 37, -5);  

    if (DayOfWeek == 1 && ch == 2)  tripleDraw (0, 30, 1);
    if (DayOfWeek == 2 && ch == 2)  tripleDraw (1, 31, 0);
    if (DayOfWeek == 3 && ch == 2)  tripleDraw (2, 32, -1);
    if (DayOfWeek == 4 && ch == 2)  tripleDraw (3, 33, -2);
    if (DayOfWeek == 5 && ch == 2)  tripleDraw (4, 35, -3);
    if (DayOfWeek == 6 && ch == 2)  tripleDraw (5, 36, -4);
    if (DayOfWeek == 7 && ch == 2)  tripleDraw (6, 37, -5);