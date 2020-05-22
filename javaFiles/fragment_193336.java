String str1 = "Abc";               // string pool

String str2 = "XYZ";               // string pool

String str3 = str1 + str2;         // not string pool (!!)

String str3a = "Abc" + "XYZ";      // string pool 

String str4 = new String("PQR");   // not string pool (but the "PQR" literal is)

String str5 = str1.concat(str4);   // not string pool 

String str6 = str1 + str4;         // not string pool

String str7 = str6.intern();       // string pool