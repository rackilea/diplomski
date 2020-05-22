if (JNI_CreateJavaVM(&vm, (void **) &vm_env, &vm_args) < 0)
    {
        for (unsigned int i = 0; i < nOptions; i++)
            delete vm_options[i].optionString;

        PyErr_Format(PyExc_ValueError,
                     "An error occurred while creating Java VM");
        return NULL;
    }