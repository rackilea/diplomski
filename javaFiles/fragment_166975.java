Vector<Number> numbers = new Vector<Number>();

    numbers.add(new Double(1.2));
    numbers.add(new Float(-1.2));
    numbers.add(new Double(4.8));
    numbers.add(new Float(-3.4));
    numbers.add(new Long(123456));
    numbers.add(new Short("14"));

    For.each(numbers, new Visitor<Number>() {
        public void doIt(Double n) {
            System.out.println("doIt() for double: " + n);
        }
        public void doIt(Float n) {
            System.out.println("doIt() for float: " + n);
        }
        public void doIt(Number n) {
            System.out.println("doIt() for Number: " + n);
        }
    });