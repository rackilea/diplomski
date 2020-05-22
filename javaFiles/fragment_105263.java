Quicksort low = new Quicksort(arr, low, i-1);
low.start(); // Start first thread
Quicksort high = new Quicksort(arr, i+1, high);
high.start(); // While first thread is running, start second.
low.join(); // Wait for first thread.
high.join(); // Immediately returns if already finished