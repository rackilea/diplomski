jint modifiersPtr;
   jvmti->GetFieldModifiers(classPtr, jfieldID, &modifiersPtr);

   if (modifiersPtr & 0x0008) {
        // STATIC 
        jint jIntVal = (jbyte) env->GetStaticIntField(clazz, fieldId);

    } else {
        // NON-STATIC
        jint jIntVal = (jbyte) env->GetIntField(objectValuePtr, fieldId);
    }