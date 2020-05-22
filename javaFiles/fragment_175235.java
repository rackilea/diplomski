function newCounter() { 
    let count = 0; 
    return function() { return ++count; }; 
} 
const nc = newCounter(); 
console.log(nc()); // 1 
console.log(nc()); // 2 
console.log(nc()); // 3