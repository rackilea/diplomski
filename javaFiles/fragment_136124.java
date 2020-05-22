static class Razred {}

static class DayDef {}
static class Pon extends DayDef {}
static class Tor extends DayDef {}
static class Sre extends DayDef {}
static class Cet extends DayDef {}
static class Pet extends DayDef {}

static class DayDefU {}
static class PonU extends DayDefU {}
static class TorU extends DayDefU {}
static class SreU extends DayDefU {}
static class CetU extends DayDefU {}
static class PetU extends DayDefU {}

static class Urnik {

    private String string;
    private int i;
    private Razred razred;
    private DayDef dayDef;
    private DayDefU dayDefU;

    public Urnik(String string, int i, Razred razred, DayDef dayDef,
            DayDefU dayDefU) {
                this.string = string;
                this.i = i;
                this.razred = razred;
                this.dayDef = dayDef;
                this.dayDefU = dayDefU;
    }

    // getters and setters for every field

}

public static void main(String[] args) {

    Razred razred = new Razred();

    List<Urnik> urniks = new ArrayList<Urnik> ();

    for (int i = 0; i < 11; i++){
        urniks.add(new Urnik("Ponedeljek", i+1, razred, new Pon(), new PonU()));
        urniks.add(new Urnik("Torek", i+1, razred, new Tor(), new TorU()));
        urniks.add(new Urnik("Sreda", i+1, razred, new Sre(), new SreU()));
        urniks.add(new Urnik("Četrtek", i+1, razred, new Cet(), new CetU()));
        urniks.add(new Urnik("Petek", i+1, razred, new Pet(), new PetU()));
    }

}