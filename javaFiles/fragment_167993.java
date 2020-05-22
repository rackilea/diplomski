import jnr.posix.*;

final POSIX p = POSIXFactory.getPOSIX();
final int S_BLKSIZE = 512; // from sys/stat.h
final FileStat stat = p.stat("/some/file.txt");
final long bytes = stat.blocks() * S_BLKSIZE;