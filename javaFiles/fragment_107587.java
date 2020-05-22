String currentDate = "";
for(int i = 0; i < myDates.size(); i++)
{
    String next = myDates.get(i);
    String nextPro = myProducsts.get(i) + "\n";
    if (currentDate.equals(next)) {
        dates.append(nextPro);
    } else {
        dates.append(next + nextPro);
        currentDate = next;
    }
}