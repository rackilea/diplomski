private static FileDescriptor open(String pathForWindows,
                                       String pathToCheck,
                                       Flags flags,
                                       long pSecurityDescriptor)
        throws WindowsException
    {
        ...
        int dwShareMode = 0;
        if (flags.shareRead)
            dwShareMode |= FILE_SHARE_READ;
        if (flags.shareWrite)
            dwShareMode |= FILE_SHARE_WRITE;
        if (flags.shareDelete)
            dwShareMode |= FILE_SHARE_DELETE;
        ...
        // open file
        long handle = CreateFile(pathForWindows,
                                 dwDesiredAccess,
                                 dwShareMode,
                                 pSecurityDescriptor,
                                 dwCreationDisposition,
                                 dwFlagsAndAttributes);
        ...
    }