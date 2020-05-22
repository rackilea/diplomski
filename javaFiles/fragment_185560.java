public Car copy(Car c)
{
    c.make = this.make;
    c.model = this.model;
    c.year = this.year;
    return c; // But needs all properties to be same as current instance of class.
}