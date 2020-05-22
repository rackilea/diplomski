jchar *carr; 
carr = (*env)->GetCharArrayElements(env, bits, NULL); 
if (carr == NULL) {
    return 0; /* exception occurred */ 
} 
//for (int i=0; i<10; i++) {
//    do something with carr[i]; 
//} 
(*env)->ReleaseCharArrayElements(env, bits, carr, 0);