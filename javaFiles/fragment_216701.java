long t = new Date().getTime(); // time now in millies
do {
    // do something here
    // ...
    final long now = new Date().getTime();
    if( now - t >= 1000 ) {
       // do your logging
       // ...
       t = new Date().getTime();  // reset reference time
    }
} while( someCondition );