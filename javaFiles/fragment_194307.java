if(q1<=q2 && q1<=q3 ){          // q1 is the smallest
        System.out.println("q1");
    } else if (q2<=q3) {            // q2 is smaller than q3, we have tested q1 in the previous if
        System.out.println("q2");
    } else {                        // if neither q1 nor q2 is the smallest, it has to be q3
        System.out.println("q3");
    }