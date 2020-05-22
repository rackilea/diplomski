public Point getEndpointA(Point midpoint, double angleDegee, double length) {
                Point a = new Point(0, 0);

                // convert degrees=>radians
                final double angleRad = Math.toRadians(angleDegee);

                a.x = (int) (midpoint.x + (int) length * Math.cos(angleRad));
                a.y = (int) (midpoint.y + (int) length * Math.sin(angleRad));

                return a;
        }

        public Point getEndpointB(Point midpoint, double angleDeg, double length) {
                Point b = new Point(0, 0);

                final double angleRad = Math.toRadians(angleDeg + 180d);

                b.x = (int) (midpoint.x + (int) length * Math.cos(angleRad));
                b.y = (int) (midpoint.y + (int) length * Math.sin(angleRad));

                return b;
        }