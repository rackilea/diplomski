ClassFile {
    //...
    u2 constant_pool_count;
    cp_info constant_pool[constant_pool_count-1];
    //...
    u2 super_class;
    u2 interfaces_count;
    u2 interfaces[interfaces_count];
}