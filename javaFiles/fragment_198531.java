ArrayList<String> vars = new ArrayList<String(9);
for (int i = 1; i <= 9; i++)
{
    vars.add("hi" + i);
    Toast.makeText(this, vars.get(i), Toast.LENGTH_SHORT).show();
}