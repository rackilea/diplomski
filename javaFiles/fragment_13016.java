public class Lestvica {

private int razmak;
private Nota zacetnaNota;

public Lestvica(Nota zacetnaNota, int razmak) {
    this.zacetnaNota = zacetnaNota;
    this.razmak = razmak;
}

public Nota clen(int indeks) {
    int paDelimo = 0;
    int dobljenaOktava = 0;
    int dobljeniIndeks = 0;

    paDelimo = zacetnaNota.vrniOktavo() + zacetnaNota.vrniIndeks() + this.razmak * indeks;

    dobljenaOktava = paDelimo / 12;
    dobljeniIndeks = paDelimo % 12;
    Nota drugaNota = new Nota(dobljenaOktava, dobljeniIndeks);
    return drugaNota;
}