public interface ProgramContainer { 
    Program getProgram();
    ...
}

public class LibAContainer implements ProgramContainer {
    private final LibA libA;
    public LibAContainer(LibA libA) {
        this.libA = libA;
    }
    public Program getProgram() {
        return libA.getProgram();
    }
    ...
}