public class DoubleOSeven {
    public static final String S_SHOOT = "shoot";
    public static final String S_BLOCK = "block";
    public static final String S_RELOAD = "reload";
    public static final int I_SHOOT = 1;
    public static final int I_BLOCK = 2;
    public static final int I_RELOAD = 3;

    ...
    System.out.println("Enter ("+ S_SHOOT + ", " + S_RELOAD + " or " + S_BLOCK + ") ");

    ...
    } else if(userAction.equals(S_BLOCK)){
        System.out.println("You blocked, Your ammo count is at: " + userAmmo);  
    }

    if(compAction == I_SHOOT){
        compAmmo--;    // I changed ++ to -- in order to be a fair game
        System.out.println("I took a shot at you, My ammo count is at: " + compAmmo);
    } else if(compAction == I_BLOCK){
        System.out.println("I blocked, My ammo count is at: " + compAmmo);
    ...