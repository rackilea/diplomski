function A() {
}

A.prototype.doStuff = function() {
    console.log("hello world");
};

function B() {
}

B.prototype = Object.create(A.prototype);
B.prototype.doStuff = function() {
    A.prototype.doStuff.call(this);
    console.log("...and goodbye!");
};