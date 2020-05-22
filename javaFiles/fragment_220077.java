Bundle objID = getIntent().getExtras();
int x = objID .getInt("d");     

if (MainActivity.listobjs.get(x).getID()
.equals(objID.getString("object") ))
{
        selOBJ = MainActivity.listobjs.get(x);
    }