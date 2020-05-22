FD
winFileHandleOpen(JNIEnv *env, jstring path, int flags)
{
    ...
    const DWORD sharing =
        FILE_SHARE_READ | FILE_SHARE_WRITE;
    ... // "sharing" not updated anymore
    h = CreateFileW(
        pathbuf,            /* Wide char path name */
        access,             /* Read and/or write permission */
        sharing,            /* File sharing flags */
        NULL,               /* Security attributes */
        disposition,        /* creation disposition */
        flagsAndAttributes, /* flags and attributes */
        NULL);
    ...
}