import com.google.gwt.core.client.JavaScriptObject;

public class MyStatusResults extends JavaScriptObject
{

   protected MyStatusResults()
   {
      // Intentionally empty
   }

   /**
    * Returns the total number of results for this search.
    *
    * @return the total number of results for this search.
    */
   public final native int getTotalResults() /*-{
   return this.total;
   }-*/;

   /**
    * Returns the entry results of the search.
    *
    * @return the entry results of the search.
    */
   public final native MyStatus[] getResults() /*-{
   return this.entries;
   }-*/;
}