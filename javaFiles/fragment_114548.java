long last_click = 0;

// this is you interval time in milliseconds
long myTimeMillis = 1000;

// ... ... ...

// inside button click function

long time = System.currentTimeMillis()

if(time-last_click > myTimeMillis){
    do_taskA();
}else{
    do_taskB();
}

last_click = time;