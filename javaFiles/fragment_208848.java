/*Copy ArrayList into 2D array to display in JTable format*/
private void printData() 
{
    for(int i=0; i<name.size(); i++)
    {
        data[i][0]=name.get(i);
        data[i][1]=department.get(i);
        data[i][2]=salary.get(i);
    }
    resultTable = new JTable(data, columnNames);
    outputPanel = new JPanel();
    outputPanel.add(resultTable);
}