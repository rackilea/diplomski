package root.javalanguage.realtemplates;

import root.javalanguage.realtemplates.RealTemplateGenerator.*;

@GenerateArg(from=TemplateArgOne.class,to=double.class)
@GenerateFrom(root.javalanguage.realtemplates.EndlessArray.class)
public class EndlessArrayDouble {
    double[] values;
    int size = 0;
    int capacity;
    public EndlessArrayDouble() {
        capacity = 10;
        values = new double[capacity];
    }
    public void reserve(int newcapacity ) {
        if( newcapacity > capacity ) {
            double[] newvalues = new double[newcapacity];
            for( int i = 0; i < size; i++ ) {
                newvalues[i] = values[i];
            }
            values = newvalues;
            capacity = newcapacity;
        }
    }
    public void add( double value ) {
        if( size >= capacity - 1 ) {
            reserve( capacity * 2);
        }
        values[size] = value;
    }
    public void set( int i, double value ) {
        values[i] = value;
    }
    public double get( int i ) {
        return values[i];
    }
}