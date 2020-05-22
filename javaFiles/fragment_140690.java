double[] numbers = {355, 5, 15 };
    double sin=0.0, cos=0.0, theta=0.0;

    for(double d : numbers) {
        double s = Math.sin(Math.toRadians(d));
        sin += s;

        double c = Math.cos(Math.toRadians(d));
        cos += c;
    }

    sin = sin / ((double)numbers.length);
    cos = cos / ((double)numbers.length);

    // Using only atan2
    System.out.println("Atan2 Only: " + Math.toDegrees(Math.atan2(sin, cos)));
    // Atan2 Only: 159.71920992022936

    // Using the wiki solution
    if (sin > 0 && cos > 0) {
        theta = Math.atan(sin/cos);
    } else if(cos < 0) {
        theta = Math.atan(sin/cos) + 180;
    } else if(sin < 0 && cos > 0) {
        theta = Math.atan(sin/cos) + 360;
    }
    System.out.println("Wiki Answer: " + theta);
    System.out.println("Wiki Answer in degrees: " + Math.toDegrees(theta));