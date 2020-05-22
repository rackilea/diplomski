public class Club {
   private ArrayList<Player> members = new ArrayList<>();

   public void add( Player player ) {
      members.add( player );
   }

   public String listMemebers() {
     if( members.size() == 0 ) return "";
     StringBuilder sb = new StringBuilder();
     for( Player p : members ) {
       sb.append( p.getFirstName() );
       sb.append( " " );
       sb.append( p.getLastName() );
       sb.append( ", " );
    }
    sb.setLength( sb.length()-2 );
    return sb.toString();
  }
}