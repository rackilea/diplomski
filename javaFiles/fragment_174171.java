public class WeihnachtsbaeckereiTest {

    public class Zutat {
        public String Namen;
        public int Menge;
    }

    public class Teig {

        public boolean geknetet;

        // Add a Zutat, not a String
        public void zutatHinzufugen(Zutat dazu) {
            System.out.println("Zutat hinzugefuegf: " + dazu.Namen + " (" + dazu.Menge + "g)");
        }

        public void kneten() {
            geknetet = true;
            System.out.println("Teig geknetet");
        }
    }

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

    public void main(String[] args) {
        Teig teig = new Teig();
        Zutat zutat1 = new Zutat();
        Zutat zutat2 = new Zutat();
        Zutat zutat3 = new Zutat();
        zutat1.Namen = "Mehl";
        zutat1.Menge = 200;
        zutat2.Namen = "Zucker";
        zutat2.Menge = 100;
        zutat3.Namen = "Eier";
        zutat3.Menge = 150;

        teig.zutatHinzufugen(zutat1);
        teig.zutatHinzufugen(zutat2);
        teig.zutatHinzufugen(zutat3);
        teig.kneten();

        //You need an ofen
        Ofen ofen = new Ofen();

        //You bake only once
        if (ofen.backen(teig, 180)) {
            System.out.println("Hmmmm lecker");
        } else {
            System.out.println("Leider schief gegangen");
        }
    }
}