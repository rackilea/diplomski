Semaphore semaphore= new Semaphore(No of Lizards that can cross the road at a time);


sagoToMonkeyIsSafe();<-- semaphore.acquire(); as crossing the path start
 // cross path to monkey grass
crossedOverToMonkey();<---semaphore.release(); as crossing the path end

monkeyToSagoIsSafe();<-- semaphore.acquire(); as crossing the path start
// cross from cross monkey grass to sage
crossMonkeyToSago();<---semaphore.release();  as crossing the path end