@Override
public Object getValueAt(int row, int column) {
    DataHolder data = dataVector_.get(row);
    switch(column) {
        case 0: return data.month;
        case 1: return data.day;
        case 2: return data.year;
        default: return null;
    }