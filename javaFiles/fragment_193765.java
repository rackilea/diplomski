fieldID = env->GetFieldID( identifyResultClass , "identParams", "Ljava/util/List;" );
    if( fieldID != NULL ) 
    {
        // Find "java/util/List" Class (Standard JAVA Class).
        jclass listClass = env->FindClass( "java/util/List" );
        if( listClass == NULL ) {
            DBG_WARNING(DBG_CTX, ("Can't Find Class \"java/util/List\".\n"));
            return -1;
        }

        // Get List object field.
        jobject listObject = env->GetObjectField( methodReturnObj, fieldID );
        if( listObject == NULL ) {
            DBG_WARNING(DBG_CTX, ("Can't get ObjectField for \"List\".\n"));
            return -1;
        }

        // Get "java.util.List.get(int location)" MethodID
        jmethodID getMethodID = env->GetMethodID( listClass, "get", "(I)Ljava/lang/Object;" );
        if( getMethodID == NULL ) {
            DBG_WARNING(DBG_CTX, ("Can't get MethodID for \"java.util.List.get(int location)\".\n"));
            return -1;
        }

        // Get "int java.util.List.size()" MethodID
        jmethodID sizeMethodID = env->GetMethodID( listClass, "size", "()I" );
        if( sizeMethodID == NULL ) {
            DBG_WARNING(DBG_CTX, ("Can't get MethodID for \"int java.util.List.size()\".\n"));
            return -1;
        }

        // Call "int java.util.List.size()" method and get count of items in the list.
        int listItemsCount = (int)env->CallIntMethod( listObject, sizeMethodID );
        DBG_DISPLAY(DBG_CTX,("List has %i items\n", listItemsCount));

        for( int i=0; i<listItemsCount; ++i )
        {
            // Call "java.util.List.get" method and get IdentParams object by index.
            jobject identParamsObject = env->CallObjectMethod( listObject, getMethodID, i - 1 );
            if( identParamsObject == NULL )
            {
                DBG_WARNING(DBG_CTX, ("Can't get Object from \"identParamsObject\" at index %i.\n", i - 1));
            }


        }