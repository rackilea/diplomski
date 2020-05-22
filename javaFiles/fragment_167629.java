import java.util.*;
import java.lang.*;
import java.io.*;

class CharacterStatus
{

    public  enum StatusFlags {
        DEAD,
        PARALYZED,
        SLEEPING,
        CONFUSED,
        POISONED,
        BURNING,
        FROZEN;
    }

    private EnumSet<StatusFlags> status; 

    public EnumSet<StatusFlags> getStatus () {
        return this.status;
        // you could return another format if you like, e.g., string array
    }

    public String toString() {
        String s = "";
        for (StatusFlags stat  : this.status){
            s+= stat.toString()+"\n";
        }
        return s;   
    }


    public CharacterStatus () {
        this.status = EnumSet.noneOf(StatusFlags.class);
        // declare a Status Flag with all bits set to 0
    }

    public void setBit(StatusFlags effect) {
        this.status.add(effect);
        // It should set the correct bit Based on DEAD, PARALYZED etc
    }

    public void clearBit (String effect) {
        this.status.remove(effect);
        // It should clear the correct bit Based on DEAD, PARALYZED etc
    }


    public static void main (String[] args) throws java.lang.Exception
    {
        CharacterStatus status = new CharacterStatus ();
        status.setBit (StatusFlags.CONFUSED);
        System.out.println(status.toString());
    }
}