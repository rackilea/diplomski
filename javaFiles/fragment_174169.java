public class Ofen {
        // You bake the Teig, not the Zutat
        public boolean backen(Teig teig, int Temperatur) {
            if (Temperatur < 200) {
                return (true);
            } else {
                return (false);
            }
        }

    }