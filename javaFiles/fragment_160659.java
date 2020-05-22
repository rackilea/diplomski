// calculating some useful values.
        double t = -(f - m) / (2.0 * d);
        double u = t * t - (g - b) / (double) d;

        // the first polynomial is linear, so both terms are.
        if (d == 0) {
            // both linear functions have the same slope.
            if (f == m) {
                // both functions are shifted the same amount along the y-Axis.
                if (g == b)
                    // the functions lie on top of each other.
                    System.out.println("There is an infinite amount intersections");
                // the functions are shifted different amounts along the y-Axis.
                else
                    // the lines are parallel.
                    System.out.println("There are no intersections");
            }
            // both linear functions have different slopes.
            else {
                // solve linear equation.
                double x = (b - g) / (double) (f - m);
                double y = m * x + b;
                System.out.println("The intersection is: (" + x + "," + y + ")");
            }
        }
        // the functions do not cross each other.
        else if (u < 0)
            System.out.println("There are no intersections");
        // the linear function is a tangent to the quadratic function.
        else if (u == 0) {
            // solve equation.
            double x = t;
            double y = m * x + b;
            System.out.println("The intersection is: (" + x + "," + y + ")");
        }
        // the linear function intersects the quadratic function at two points.
        else {
            // solve quadratic equation.
            double x1 = t + Math.sqrt(u);
            double x2 = t - Math.sqrt(u);
            double y1 = m * x1 + b;
            double y2 = m * x2 + b;
            System.out.println("The intersections are: (" + x1 + "," + y1 + ") (" + x2 + "," + y2 + ")");
        }