@Override
public Class getColumnClass(int column)
{

    switch (column)
    {
        case 7: return Icon.class();
        default: return Object.class;
    }
}