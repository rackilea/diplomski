// Notice default scoping
interface DataSourceInterface {
    //This is to allow our GenericDataSource to call a method that isn't defined yet.
    Object cursorToMe(Cursor cursor);
}

//Notice how we implement here?, but no implemented function declarations!
public abstract class GenericDataSource implements DataSourceInterface {
    protected SQLiteDatabase database;

    // and here we see Generics and Objects being friends to do what we want.
    // This basically says ? (wildcard) will have a list of random things
    // But we do know that these random things will extend from an Object
    protected List<? extends Object> getAll(String table, String[] columns){
        List<Object> items = new ArrayList<Object>();

        Cursor cursor = database.query(table, columns, null, null, null, null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            // And see how we can call "cursorToMe" without error!
            // depending on the extending class, cursorToMe will return 
            //   all sorts of different objects, but it will be an Object nonetheless!
            Object object = this.cursorToMe(cursor);
            items.add(object);
            cursor.moveToNext();
        }
        // Make sure to close the cursor
        cursor.close();
        return items;
    }
}

//Here we extend the abstract, which also has the implements.
// Therefore we must implement the function "cursorToMe"
public class ColonyDataSource extends GenericDataSource {
    protected String[] allColumns = {
        ColonyOpenHelper.COLONY_COLUMN_ID, 
        ColonyOpenHelper.COLONY_COLUMN_TITLE, 
        ColonyOpenHelper.COLONY_COLUMN_URL
    };

    // Notice our function overloading!
    //    This getAll is also changing the access modifier to allow more access
    public List<Colony> getAll(){
        //See how we are casting to the proper list type?
        // Since we know that our getAll from super will return a list of Colonies.
        return  (List<Colony>)super.getAll(ColonyOpenHelper.COLONY_TABLE_NAME, allColumns);
    }


    //Notice, here we actually implement our db hash to object
    // This is the part that would only be able to be done through reflection or what/not
    // So it is better to just have your DataSource object do what it knows how to do.
    public Colony cursorToMe(Cursor cursor) {
        Colony colony = new Colony();
        colony.setId(cursor.getLong(0));
        colony.setTitle(cursor.getString(1));
        colony.setUrl(cursor.getString(2));
        return colony;
    }
}