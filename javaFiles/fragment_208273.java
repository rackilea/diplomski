long bytes = 3434901120028l;
long gb = bytes / (1024 * 1024 * 1024);
bytes -= gb * 1024 * 1024 * 1024;
long mb = bytes / (1024 * 1024);
bytes -= mb * 1024 * 1024;

long kb = bytes / 1024;
bytes -= kb * 1024;

if (gb > 0) {
    System.out.printf("%d gigabytes ", gb);
}
if (mb > 0) {
    System.out.printf("%d megabytes ", mb);
}
if (kb > 0) {
    System.out.printf("%d kilobytes ", kb);
}
if (bytes > 0) {
    System.out.printf("%d bytes ", bytes);
}