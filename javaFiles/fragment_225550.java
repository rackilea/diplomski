// we will need a factory method
var createVertex = (function() { // i hope you are familiar with "inline" function calls

    // private variables used in every call of factory method - but initialized once
    var 
        JObjExtender = Java.extend(Java.type("java.lang.Object")),
        JInteger = Java.type("java.lang.Integer"),
        _equals = function(other) { 
            return this.from === other.from; 
        },
        _hashCode = function() { 
            return JInteger.hashCode(+this.from); // leading "+" converts to number
        };

    // the "actual" factory method
    return function(from, cost) {
        return new JObjExtender() {
            from : from,
            cost : cost, 
            equals : _equals,
            hashCode : _hashCode
        };
    };
})();

var vertex = createVertex(1, 10);
hm.put(vertex, 10);