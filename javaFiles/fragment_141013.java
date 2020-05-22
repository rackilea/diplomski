ScheduledExecutorService bla;    
//Put a bunch of scheduled stuff in a map
for(int i = 0; i < 10; i++){
    map.put(i, bla.schedule(() -> {}, 10, TimeUnit.DAYS));  
}
//Cancel number 5
map.get(5).cancel(true);