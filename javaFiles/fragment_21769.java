class Class<T> {
    public constructor(private target: object) {}
    public getName(): string {
        return this.target.constructor.name;
    }
}

declare global {
    interface Object {
        getClass<T extends object>(this:T): Class<T>; 
    }
}

Object.prototype.getClass = function (this: object){
    return new Class(this);
}
class A {

}

console.log(new A().getClass().getName()) // A