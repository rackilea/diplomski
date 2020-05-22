pointcut callSetter(PropertySupport b, BindableMethod bm) : 
    call(@BindableMethod * *(..)) 
    && target(b)
    && @annotation(bm);

void around(PropertySupport b,BindableMethod bm) : callSetter( b,bm ){
    bm.type();
}