function Person(name,address) {
    this.getName = function() { return name };
    this.getAddress = function() { return address };
}

Person.prototype.hello = function() {
    return "I'm " + this.getName() + " from " + this.get<CTRL-SPACE>;
}