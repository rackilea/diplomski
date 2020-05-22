// Marsaglia's xor-shift scheme with thread-specific state
 // This is probably the best overall implementation -- we'll
 // likely make this the default in future releases.
 unsigned t = Self->_hashStateX ;
 t ^= (t << 11) ;
 Self->_hashStateX = Self->_hashStateY ;
 Self->_hashStateY = Self->_hashStateZ ;
 Self->_hashStateZ = Self->_hashStateW ;
 unsigned v = Self->_hashStateW ;
 v = (v ^ (v >> 19)) ^ (t ^ (t >> 8)) ;
 Self->_hashStateW = v ;
 value = v ;