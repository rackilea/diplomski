@Override
public Object getValueAt(int row, int column)
{
    Part part = getRow(row);         // Gets the part in question

    switch(column)
    {
    case 0:
        return part.getPartName(part); // lowercase "part"
    case 1:
        return part.getMake(); // lowercase "part"
    case 2:
        return part.getPartNumber(); // lowercase "part"
    //... do you see what I'm trying to do here?
    // continue to do this for all your other "Part.whateverMethod("