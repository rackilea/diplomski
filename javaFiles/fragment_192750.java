jbyteArray bytes;

JNF_COCOA_ENTER(env);   

// Assign and full the bytes array here, doing any requisite transformations.
// Remember to COPY any data out of COCOA objects, as references will be dead soon!

JNF_COCOA_EXIT(env);

return bytes;