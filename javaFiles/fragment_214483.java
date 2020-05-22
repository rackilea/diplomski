/* rawcopy -- pure C, system calls only, copy argv[1] to argv[2] */

/* This is a test program which simply copies from file to file using
 * only system calls (section 2 of the manual.)
 *
 * Compile:
 *
 *      gcc -Wall -DBUFSIZ=1024 -o rawcopy rawcopy.c
 *
 * If DIRTY is defined, then errors are interpreted with perror(3).
 * This is ifdef'd so that the CLEAN version is free of stdio.  For
 * convenience I'm using BUFSIZ from stdio.h; to compile CLEAN just
 * use the value from your stdio.h in place of 1024 above.
 *
 * Compile DIRTY:
 *
 *      gcc -DDIRTY -Wall -o rawcopy rawcopy.c
 *
 */
#include <fcntl.h>
#include <sys/types.h>
#include <sys/uio.h>
#include <stdlib.h>
#include <unistd.h>
#if defined(DIRTY)
#   if defined(BUFSIZ)
#       error "Don't define your own BUFSIZ when DIRTY"
#   endif
#   include <stdio.h>
#   define PERROR perror(argv[0])
#else
#   define CLEAN
#   define PERROR
#   if ! defined(BUFSIZ)
#       error "You must define your own BUFSIZ with -DBUFSIZ=<number>"
#   endif
#endif

char * buffer[BUFSIZ];          /* by definition stdio BUFSIZ should
                                   be optimal size for read/write */

extern int errno ;              /* I/O errors */

int main(int argc, char * argv[]) {
    int fdi, fdo ;              /* Input/output file descriptors */
    ssize_t len ;               /* length to read/write */
    if(argc != 3){
        PERROR;
        exit(errno);
    }

    /* Open the files, returning perror errno as the exit value if fails. */
    if((fdi = open(argv[1],O_RDONLY)) == -1){
        PERROR;
        exit(errno);
    }
    if((fdo = open(argv[2], O_WRONLY|O_CREAT)) == -1){
        PERROR;
        exit(errno);
    }

    /* copy BUFSIZ bytes (or total read on last block) fast as you
       can. */
    while((len = read(fdi, (void *) buffer, BUFSIZ)) > -1){
        if(len == -1){
            PERROR;
            exit(errno);
        }
        if(write(fdo, (void*)buffer, len) == -1){
            PERROR;
            exit(errno);
        }
    }
    /* close and fsync the files */
    if(fsync(fdo) ==-1){
        PERROR;
        exit(errno);
    }
    if(close(fdo) == -1){
        PERROR;
        exit(errno);
    }
    if(close(fdi) == -1){
        PERROR;
        exit(errno);
    }

    /* if it survived to here, all worked. */
    exit(0);
}