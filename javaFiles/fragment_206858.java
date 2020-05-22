ptr =(*env)->GetStaticObjectField(env,cls,myNamesID);

for (i=0; i < len; i++) {

stringg = (*env)->GetObjectArrayElement(env, ptr,i);

    myStr = (*env)->NewStringUTF(env,myNames[i]);

    (*env)->SetObjectArrayElement(env,ptr,i,myStr);
}

    (*env)->ReleaseCharArrayElements(env, ptr, stringg, 0);