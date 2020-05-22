int males = 2;  // <- your map value here
int females = 1;  // <- your map value here

int total = males + females;

double chanceMale = .5;

if (total > 0) {

    chanceMale = females / (double)total;

}