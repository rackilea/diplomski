@Override
public synchronized Serializable generate(SessionImplementor session, Object obj) {
    if (obj instanceof SupportTicket) {
        Session s = (Session) session;
        String sequenceName = ((SupportTicket) obj).getProjectId();
        Sequences sequences = (Sequences) s.get(Sequences.class, sequenceName);
        long next = 1;
        if (sequences == null) {
            sequences = new Sequences(sequenceName, next);
        } else {
            next = sequences.getNext() + 1;
            sequences.setNext(next);
        }
        s.saveOrUpdate(sequences);
        return sequenceName + "-" + next;
    } else {
        return null;
    }
}