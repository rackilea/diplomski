public class LineUp {
    Act[] acts;
    int number;

    public LineUp() {
        acts = new Act[30]; // you assign to 'this' you don't create a new one
        number = 0; 
    }

    void addAct(Act a) {
        acts[number] = a;
        number++;
    }
}