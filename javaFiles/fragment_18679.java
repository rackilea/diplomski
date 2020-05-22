@GenerateFrom(EndlessArray.class)
public class EndlessArray {
    TemplateArgOne[] values;
    int size = 0;
    int capacity;
    public EndlessArray() {
        capacity = 10;
        values = new TemplateArgOne[capacity];
    }
    public void reserve(int newcapacity ) {
        if( newcapacity > capacity ) {
            TemplateArgOne[] newvalues = new TemplateArgOne[newcapacity];
            for( int i = 0; i < size; i++ ) {
                newvalues[i] = values[i];
            }
            values = newvalues;
            capacity = newcapacity;
        }
    }
    public void add( TemplateArgOne value ) {
        if( size >= capacity - 1 ) {
            reserve( capacity * 2);
        }
        values[size] = value;
    }
    public void set( int i, TemplateArgOne value ) {
        values[i] = value;
    }
    public TemplateArgOne get( int i ) {
        return values[i];
    }
}