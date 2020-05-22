package tst;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

import tst.Ada_Lib.My_Ada_Lib;

public class TestMyLib {

    private static My_Ada_Lib theLib = Ada_Lib.My_Ada_Lib.synchronizedInstance;

    public static void main(String[] args) {

        String lorem = "Sin autem ad adulescentiam perduxissent, dirimi tamen interdum contentione vel uxoriae condicionis vel commodi alicuius, quod idem adipisci uterque non posset. Quod si qui longius in amicitia provecti essent, tamen saepe labefactari, si in honoris contentionem incidissent; pestem enim nullam maiorem esse amicitiis quam in plerisque pecuniae cupiditatem, in optimis quibusque honoris certamen et gloriae; ex quo inimicitias maximas saepe inter amicissimos exstitisse." +
                "\n" +
                "Quanta autem vis amicitiae sit, ex hoc intellegi maxime potest, quod ex infinita societate generis humani, quam conciliavit ipsa natura, ita contracta res est et adducta in angustum ut omnis caritas aut inter duos aut inter paucos iungeretur." +
                "\n" +
                "Haec subinde Constantius audiens et quaedam referente Thalassio doctus, quem eum odisse iam conpererat lege communi, scribens ad Caesarem blandius adiumenta paulatim illi subtraxit, sollicitari se simulans ne, uti est militare otium fere tumultuosum, in eius perniciem conspiraret, solisque scholis iussit esse contentum palatinis et protectorum cum Scutariis et Gentilibus, et mandabat Domitiano, ex comite largitionum, praefecto ut cum in Syriam venerit, Gallum, quem crebro acciverat, ad Italiam properare blande hortaretur et verecunde.\n";

        // in params
        int inputInt = 25;

        Pointer p_Lorem = new Memory(lorem.length()+1); // +1 for C's \0
        p_Lorem.setString(0, lorem); // offset 0, no need to start at another offset

        // in param but to used for out buffer
        String stubOut = "Hello World ! 0123456789\0";
        int maxBufferSize = (stubOut.length());

        byte[] buffer = new byte[maxBufferSize];
        buffer = stubOut.getBytes();

        IntByReference usedBufferSize = new IntByReference(0); // any value works, since it is used as out param


        System.out.println("-------------------- Call to Lib ----------------------------");
        // call the lib !
        theLib.Renamed_myService(p_Lorem, inputInt, buffer, maxBufferSize, usedBufferSize);

        System.out.println("--------------------- Back to java --------------------------");
        System.out.println("In Java: used buffer size         = " + usedBufferSize.getValue());
        System.out.println("In Java: read outBuffer as String = " + Native.toString(buffer));
        System.out.println("In Java: read outBuffer as String with returned used buffer size = " + new String(buffer,0,usedBufferSize.getValue()));

    }

}