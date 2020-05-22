class DataTypaA<T extends DataTypeC>
...
class myAdapter <A extends DataTypaA<C>, 
                 B extends SparseArray<? extends DataTypeB>, 
                 C extends DataTypeC> 
    extends FragmentStatePagerAdapter { 
    A myFragment;
    SparseArray<B> data;
    C items;
...