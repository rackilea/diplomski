/* Maximum JVM memory */
maxMemory = getIntProperty(properties, "wrapper.java.maxmemory", 0);
if (maxMemory > 0) {
    maxMemory = __min(__max(maxMemory, initMemory), 4096);  /* initMemory <= n <= 4096 */
    if (strings) {
        strings[index] = malloc(sizeof(char) * (5 + 4 + 1));  /* Allow up to 4 digits. */
        sprintf(strings[index], "-Xmx%dm", maxMemory);
    }
    index++;
}