class Age {
    // Generalized code for Age class
}

class Young extends Age {
    // more specific code of Young class
}

class Elder extends Age {
    // Elder class specific code
}

public class test {
    Age age ; 
    int ageValue ;

    public Age returnVal(int ageValue){
        if (ageValue < 20) {
            age = new Young();
        } else { 
            age = new Elder();
        }

        // age object you get will be according to ageValue.
        return age;
    }
}