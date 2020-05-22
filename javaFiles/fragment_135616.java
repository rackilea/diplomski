ComplexFormat cf = new ComplexFormat();
Complex c = cf.parse("1.110 + 2.222i");
Complex second = new Complex(2.0, 5.0);
Complex answer = c.log();        // natural logarithm.
        answer = c.cos();        // cosine
        answer = c.pow(second);  // first raised to the power of second

ComplexFormat format = new ComplexFormat(); // default format
String s1 = format.format(c);      // s1 contains "1.110 + 2.222i"
String s2 = format.format(second); // s2 contains "2.0 + 5.0i"