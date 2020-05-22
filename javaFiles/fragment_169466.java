int numberOfFunctions = 20;
int progress = 0;
...
function1();
setProgress((++progress * 100) / numberOfFunctions);  // progress is 5%
...
function20();
setProgress((++progress * 100) / numberOfFunctions);  // progress is 100%