public class PlaneetComparator implements Comparator<Planeet>
{
     @Override
     public int compare(final Planeet p1, final Planeet p2)
     {
           // Compare by names. Here, you can compare by any field you prefer.
           return p1.getNaam().compareToIgnoreCase( p2.getNaam() );
     }
}