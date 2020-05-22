double A = -0.5 * Math.log10(5) + 1;
double B = level * Math.log10(5);
double C = 0.5 * Math.log10(5);
double D = 0.5 * Math.log10(5) - 1;
double E = Math.pow(D/2, 2);

double club = (A/2) + (B - C  + E);    // OR double club = (A/2) - (B - C  + E);
double result = Math.pow(10.0, club);