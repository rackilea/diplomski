RemoteView rv = ...

/* 
exemplary rv layout:
+-----+-----+-----+-----+-----+-----+
|tv0x0|tv0x1|tv0x2|tv0x3|tv0x4|tv0x5|
+-----+-----+-----+-----+-----+-----+
|tv1x0|tv1x1|tv1x2|tv1x3|tv1x4|tv1x5|
+-----+-----+-----+-----+-----+-----+
*/

String prefix = "tv";
for(int i=0; i<2;i++)
{
    for(int j=0; j<6; j++)
    {
        // use reflection, searched in stackoverflow
        int id = getItemIdFromName(prefix+i+"x"+j); 
        // working with concrete id using RemoteView set functions, e.g
        rv.setTextViewText(id, String.ValueOf(i);
    }
}