public Row[] appArray; // Row - because you extend ArrayList<Row>

public void convertToArray()
{
    int x = size();
    appArray = toArray(new Row[x]);
}