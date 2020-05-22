Builder foo = new Builder(1, 2); // The "return" value of a ctor is the reference, foo
foo.sodium(10);   // Returns foo, but we ignore it
foo.calories(42); // Returns foo, but we ignore it

(foo.sodium(10)).calories(42);
^^^^^^^^^^^^^^^^ foo, with the side effect of setting the sodium value