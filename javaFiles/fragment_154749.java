let X = 0;
let expression = "-3*X^2-16*X+2"
let processed = expression.replace(/(\w+)\^(\w+)/g, 'Math.pow($1,$2)');

console.log(processed); // prints "-3*Math.pow(X,2)-16*X+2"
console.log(eval(processed)); // prints "2"