if (a != null)
    if (b != null)
        if (c != null)
            a.getB().getC().doSomething();
        else
            // handle c null
    else
        // handle b null
else
    // handle a null