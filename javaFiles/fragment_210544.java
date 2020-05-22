Orange or1, or2;
Apple ap1;
...
or1.equals(ap1)     // BAD
or1.equals(or2)     // Good if equals() implemented for class Orange in
                    // in the way it satisfies you.