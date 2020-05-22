public class ColValsGetter<T> {
    protected List<T> objs;
    protected Column<T> col;
    public ColValsGetter(List<T> objs, Column<T> col) {
        this.objs = objs;
        this.col = col;
    }
    public T getColValForObj(int index) {
        return col.getColVal(objs.get(index));
    }
}
public class ColValsGetterFactory< T > {
    public ColValsGetterFactory() {}
    public ColValsGetter< T > make( List< T > lt, Column< T > col ) {
        return new ColValsGetter< T >( lt, col );
    }
}
public enum ColTypes {
    VARCHAR( String.class, new ColValsGetterFactory< String >() ),
    INTEGER( Integer.class, new ColValsGetterFactory< Integer >() );

    public final Class<?> dataType;
    public final ColValsGetterFactory< ? > gf;
    public < T > ColTypes ( Class< T > dataType, ColValsGetterFactory< T > gf ) {
        this.dataType = dataType;
        this.gf = gf;
    }
}

public class DBRowFooColValsGetter {
    private String fooVal;
    private ColValsGetter< String > getter;
    public DBRowFooColValsGetter( List< DBRow > rows ) {
        this.getter = ( ColValsGetter< String > )DBRow.DBCols.FOO.colType.gf.make( rows, DBRow.DBCols.FOO );
    }
    public void complexLogicForFooOnly( int i ) {
        fooVal = getter.getColValForObj( i );
        // do a lot of stuff that only makes sense for the FOO column
    };
}