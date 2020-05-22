if (daysLate > 90)
{
    costDue = bookPrice + 10;
}
else if (daysLate >= 7)
{
    costDue = (7*0.10) + ((daysLate - 7) * 0.20);  // change here
}
else if (daysLate >= 0)
{
    costDue = daysLate*0.10;
}
else
{
    IO.reportBadInput();
}