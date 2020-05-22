import jnr.ffi.LastError;
import jnr.ffi.LibraryLoader;
import jnr.ffi.Pointer;
import jnr.ffi.Runtime;

public class Semaphore
{
    private static final int O_CREAT = 0x40;

    public interface SempahoreLibrary
    {
        Pointer sem_open(String name, int flags, int mode, int value);
        int sem_post(Pointer pointer);
        int sem_close(Pointer pointer);
    }

    public static void main(String[] args) throws Exception
    {

        LibraryLoader<SempahoreLibrary> loader = LibraryLoader.create(SempahoreLibrary.class);
        loader.library("c");
        loader.library("pthread");

        SempahoreLibrary library = loader.load();
        jnr.ffi.Runtime runtime = Runtime.getRuntime(library);

        Pointer semaphore = library.sem_open("notifier", O_CREAT, 0644, 0);
        if (semaphore == null)
        {
            int errno = LastError.getLastError(runtime);
            System.out.println("sem_open: " + errno);
            System.exit(errno);
        }

        System.out.println("semaphore: " + Long.toHexString(semaphore.address()));

        try
        {
            int error = library.sem_post(semaphore);
            System.out.println("post: " + (error == 0 ? "OK" : LastError.getLastError(runtime)));
        }
        finally
        {
            int error = library.sem_close(semaphore);
            System.out.println("close: " + (error == 0 ? "OK" : LastError.getLastError(runtime)));
        }
    }
}