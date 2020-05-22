// Make MyObject
MyObject O = new MyObject(3000);
// Wait 4 seconds
wait(4000);
// 'delete' it, the object made with `new MyObject(4000)` cannot be used anymore.
O = null;