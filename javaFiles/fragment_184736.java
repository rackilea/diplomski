double xPrime = u*(u*x + v*y + w*z)*(1d - Math.cos(theta)) 
                + x*Math.cos(theta)
                + (-w*y + v*z)*Math.sin(theta);
double yPrime = v*(u*x + v*y + w*z)*(1d - Math.cos(theta))
                + y*Math.cos(theta)
                + (w*x - u*z)*Math.sin(theta);
double zPrime = w*(u*x + v*y + w*z)*(1d - Math.cos(theta))
                + z*Math.cos(theta)
                + (-v*x + u*y)*Math.sin(theta);