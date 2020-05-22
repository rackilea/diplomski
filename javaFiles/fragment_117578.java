public class FooBar <idType extends WritableComparable<idType>, EData extends Writable, AnotherType>
    extends Foo<idType, EData>
{ 
    private AnotherType x;
    ...
}