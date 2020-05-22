private String[] Options = { "Web", "IOS", "Android" };
for (int i = 0; i < 3; i++)
    Types.addItem(Options[i]);

int index = Arrays.asList( Options ).indexOf( configProp.getProperty("Type") );
if ( index != -1 )
{
   Types.setSelectedIndex(index);
}
else if( Options.length() > 0 )
{
   Types.setSelectedIndex(0);
}