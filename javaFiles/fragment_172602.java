public final class SocketHolder implements Comparable<SocketHolder> {
   private final Socket socket;
   private final Datacenter dc;
   private final Context context;
   private final int priority;

   public SocketHolder(Socket socket, Datacenter dc, Context context) {
      super();
      this.socket = socket;
      this.dc = dc;
      this.context = context;
      this.priority = this.dc.getName().equals(Utils.CURRENT_DATACENTER.get().name()) ? 1 : 2;
   }

   @Override
   public int compareTo(SocketHolder o) {
       return Integer.compare(this.priority, o.priority);
   }
}