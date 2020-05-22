WhateverLoop whateverLoop = new WhateverLoop();
Thread WhateverLoopThread = new Thread(whateverLoop);
whateverLoopThread.start();
// Do stuff which consumes time.
...
// Stop the loop
whateverLoop.setRun(false);