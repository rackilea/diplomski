public class liveChannels {

    String name = null;
    int id;
    String link = null;
    String decryptionTicket = null;
    String viewLevel = null;
    programs programs;

    public void setPrograms (programs programs) {
        this.programs = programs;
    }

    public programs getPrograms() {
        return programs;
    }

    ...
}