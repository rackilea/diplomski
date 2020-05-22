vmInitSuccess = JNI_CreateJavaVM(&vm, (void **) &vm_env, &vm_args);
    if (vmInitSuccess < 0)
    {
        for (unsigned int i = 0; i < nOptions; i++)
            delete vm_options[i].optionString;

        //Set up basic error message
        sprintf(strVMInitSuccess, "%d", vmInitSuccess);
        strcpy(strVMError, "An error occurred while creating Java VM (No Exception): ");
        strcat(strVMError, strVMInitSuccess);

        //Get exception if there is one
        if((exc = vm_env->ExceptionOccurred()))
        {
            //Clear the exception since we have it now
            vm_env->ExceptionClear();
            //Get the getMessage() method
            if ((java_class = vm_env->FindClass ("java/lang/Throwable")))
            {
                if ((method = vm_env->GetMethodID(java_class, "getMessage", "()Ljava/lang/String;")))
                {
                    int size;
                    strExc = static_cast<jstring>(vm_env->CallObjectMethod(exc, method)); 
                    charExc = vm_env->GetStringUTFChars(strExc, NULL);
                    size = sizeof(strVMError) + sizeof(charExc);
                    char strVMException[size];
                    strcpy(strVMException, "An error occurred while creating Java VM (Exception): ");
                    strcat(strVMException, charExc);
                    PyErr_Format(PyExc_ValueError, strVMException);
                    return NULL;
                }
            }
        }
        PyErr_Format(PyExc_ValueError, strVMError);
        return NULL;
    }