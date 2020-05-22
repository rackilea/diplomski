package org.rondadev.samples;

public class StatefulCalculator {

        private StatelessCalculator calculator;

        double register = 0;

        public double add(double a) {       
            register = calculator.add(register, a); 
            return register;
        }

        public double display() {       
            return register;
        }

        public void clean() {
            register = 0;       
        }

        public void turnOff() {
            calculator = null;
            System.out.println("[StatefulCalculator] Good bye ! ");
        }

        public void turnOn() {
            calculator = new StatelessCalculator();
            System.out.println("[StatefulCalculator] Welcome !");
        }   
}