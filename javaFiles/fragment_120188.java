int cost = 0;
if (movie == 'C')
    {
        if (isWeekday(month, day))
        {
            if (isMatinee)
            {
                cost = (numberOfAdultTickets*8) + (numberOfStudentTickets*8);
            }
            else if (!isMatinee)
            {
                cost = (numberOfAdultTickets*10) + (numberOfStudentTickets*8);
            }
        }
    } else if... //rest of your code.

    return cost;
}