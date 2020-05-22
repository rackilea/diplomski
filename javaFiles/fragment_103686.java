while (hauteur > 0) {
    ++t;
    double s = sourface / masse; 
    double q = Math.exp(-s * (t - t0));
    vitesse = (g/s) * (1-q) + v0 * q; 
    hauteur = h0 - (g/s) * (t-t0) - ((v0 - (g/s)) / s) * (1-q);
    accel = g - s * vitesse;

    if (hauteur > 0) {

        if (hauteur < 2500) {
            sourface = 25.0; 
            t0 = t;
            v0 = vitesse; 
            h0 = hauteur;   
        }

        if ((hauteur <= 2500) && !printed)  {
            System.out.println("## Felix ouvre son parachute");
            printed = true;
        } 

        System.out.printf("%.0f, %.4f, %.4f, %.5f\n", t, hauteur, vitesse, accel);

   } 
}