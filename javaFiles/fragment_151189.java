public int read() {
    synchronized(resourceA) { 
        synchronized(resourceB) {

public void write() {
    synchronized(resourceA) { 
        synchronized(resourceB) {