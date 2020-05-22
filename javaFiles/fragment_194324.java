public class Test {

    int experience = 10;
    int experienceCap = 100;

    public void refreshExperience() {
        while (experience <= experienceCap) {
            experience = getExperience();
            experienceCap = getExperienceCap();
        }
    }