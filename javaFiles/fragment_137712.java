String[] properties = new String[full.length / 2];
String[] values = new String[full.length / 2];
for (int i = 0; i < properties.length; i++)
{
    properties[i] = full[i * 2];
    values[i] = full[i * 2 + 1];
}