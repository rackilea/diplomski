@Override
public String getColumnName(int c) {
    return names[c];
}

@Override
public int getColumnCount() {
    return names.length;
}