mov    0xc(%rcx),%r8d         ;*getfield sum
...
add    0x14(%r12,%r10,8),%r8d ;add a[1]
add    0x10(%r12,%r10,8),%r8d ;add a[0]
add    0x1c(%r12,%r10,8),%r8d ;add a[3]
add    0x18(%r12,%r10,8),%r8d ;add a[2]