public class Decision {
    private Decision() {} // no instance, please

    // Type is probably a bit too wide...
    static boolean mayList(Object principal) {
        return ((com.grsnet.qvs.model.Benutzer)principal).permission.u_01 == 2;
    }

    // etc...
}