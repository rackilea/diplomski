Quicksort quicksort  = new Quicksort(arr, low, i-1);
quicksort.start();  // Start new thread.
quickstart.join();  // Wait for it to run before moving on

Quicksort quicksort = new Quicksort(arr, i+1, high);
quickstart.start(); // Start second thread (after first has finished)
quickstart.join(); // Wait for second thread.