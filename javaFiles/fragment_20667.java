enum MACHINETYPE{
    WehrmachtEnigma (4, true, true, true, false),
    KriegsmarineM4(4, true, true, true, true),
    Abwehr(4, true, true, true, true);

    private final int ROTORS_COUNT;
    private final boolean[] STEPPING;

    private MACHINETYPE(int rotors, boolean... stepping){
        ROTORS_COUNT = rotors;
        STEPPING = stepping;
    }
}