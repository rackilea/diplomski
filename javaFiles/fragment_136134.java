//adds new Data to the list
public void naiveAddData(String name, double value)
{
    pieChartData.add(new Data(name, value));
}

//updates existing Data-Object if name matches
public void addData(String name, double value)
{
    for(Data d : pieChartData)
    {
        if(d.getName().equals(name))
        {
            d.setPieValue(value);
            return;
        }
    }
    naiveAddData(name, value);
}