if (m >= 3 && m <= 6) {
        if (m == 3) {
            if (d >= 20) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        } else if (m == 6) {
            if (d <= 20) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        } else {
            System.out.println(true); // you missed this print statement
        }
    } else {
        System.out.println(false);
    }