public class Pet {
    String Name, AdoptionStatus, True = "not adopted";
    int Age;

    public Pet() {}

    public Pet(String Name, int Age) {
        this.Name = Name;
        this.Age = Age;
    }

    public void SetName(String namesetup) {
        Name = namesetup;
    }

    public String GetName() {
        return Name;
    }

    public int GetAge() {
        return Age;
    }

    public int ageincrease() {
        return Age++;
    }

    public String Getadoptionstatus() {
        return AdoptionStatus;
    }

    public void Setadoptionstatus(String setadoption2) {
        AdoptionStatus = True;
    }

}