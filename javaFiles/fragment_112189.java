String[] names = new String[MainActivity.test.size()];
for(int i = begin; i<count; i++)
{
    names[i] = MainActivity.test.get(i).getName();
}
...
d.setName(names[i]);
...
bar.setBars(points);