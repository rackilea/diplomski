class Partial<V extends Integer> extends Base<Integer, V>
{
}

class Partial2<V extends Number> extends Base<Number, V> 
{
}

class Partial3<V extends Integer> extends Base<Number, V>
{
}

class Full extends Base<Integer, Integer>
{
}

class Full2 extends Base<Number, Integer>
{
}