minute = new ArrayList<String>();
for (int i = 01; i <= 60; ++i)
{
    if (i < 10) {
        minute.add("0" + String.valueOf(i));
    } else {
        minute.add(String.valueOf(i));
    }
}