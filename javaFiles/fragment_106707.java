List<Integer> list = new ArrayList<>();

for(int x = 0, y = tcm.getColumnCount(); x < y; x++)
    {
        tc = tcm.getColumn(x);
        list.add(tc.getWidth());
    }