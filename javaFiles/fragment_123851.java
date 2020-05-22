public int hashcode_shared();
   0: aload_0                           //read this
   1: getfield      #6                  //read hash (r1)
   4: ifne          12                  //compare r1 with 0
   7: aload_0                           //read this
   8: iconst_1                          //constant 1
   9: putfield      #6                  //put 1 into hash (w1)
  12: aload_0                           //read this
  13: getfield      #6                  //read hash (r2)
  16: ireturn                           //return r2

public int hashcode_local();
   0: aload_0                           //read this
   1: getfield      #6                  //read hash (r1)
   4: istore_1                          //store r1 in local variable h
   5: iload_1                           //read h
   6: ifne          16                  //compare h with 0
   9: aload_0                           //read this
  10: iconst_1                          //constant 1
  11: dup                               //constant again
  12: istore_1                          //store 1 into h
  13: putfield      #6                  //store 1 into hash (w1)
  16: iload_1                           //read h
  17: ireturn                           //return h