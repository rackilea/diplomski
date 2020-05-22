package test;

    import java.io.Serializable;
    import java.util.ArrayList;
    import java.util.Collection;
    import java.util.Set;
    import java.util.TreeSet;

    import lotus.domino.Database;
    import lotus.domino.NotesException;
    import lotus.domino.Session;
    import lotus.domino.View;
    import lotus.domino.ViewEntry;
    import lotus.domino.ViewEntryCollection;

    public class FruitController implements Serializable {

        private static final long       serialVersionUID    = 1L;
        private static final String     FRUIT_VIEW          = "(FruitsByUser)";

        private final Collection<Fruit> allFruits           = new ArrayList<Fruit>();
        private final Set<String>       colors              = new TreeSet<String>();
        private final Set<String>       shape               = new TreeSet<String>();
        private final Set<String>       taste               = new TreeSet<String>();

        private String                  colorFilter         = null;
        private String                  tasteFilter         = null;
        private String                  shapeFilter         = null;

        // if you use this controller, you only can use an object data source!
        // for a bean you would need an empty controller
        public FruitController(final Session s, final Database db) {
            this.populateData(s, db);
        }

        public final String getColorFilter() {
            return this.colorFilter;
        }

        public final String[] getColors() {
            return (String[]) this.colors.toArray();
        }

        public Collection<Fruit> getSelectedFruits() {
            Collection<Fruit> result = new ArrayList<Fruit>();

            for (Fruit f : this.allFruits) {
                if (this.matchesFilter(f)) {
                    result.add(f);
                }
            }

            return result;
        }

        public final String[] getShape() {
            return (String[]) this.shape.toArray();
        }

        public final String getShapeFilter() {
            return this.shapeFilter;
        }

        public final String[] getTaste() {
            return (String[]) this.taste.toArray();
        }

        public final String getTasteFilter() {
            return this.tasteFilter;
        }

        public void resetFilters() {
            this.setColorFilter(null);
            this.setShapeFilter(null);
            this.setTasteFilter(null);
        }

        public final void setColorFilter(String colorFilter) {
            this.colorFilter = colorFilter;
        }

        public final void setShapeFilter(String shapeFilter) {
            this.shapeFilter = shapeFilter;
        }

        public final void setTasteFilter(String tasteFilter) {
            this.tasteFilter = tasteFilter;
        }

        private boolean matchesFilter(Fruit f) {
            boolean result = true;

            result = ((result == false) ? false : ((this.colorFilter == null || "".equals(this.colorFilter.trim())) ? true
                    : (this.colorFilter.equals(f.getColor()))));
            result = ((result == false) ? false : ((this.tasteFilter == null || "".equals(this.tasteFilter.trim())) ? true
                    : (this.tasteFilter.equals(f.getTaste()))));
            result = ((result == false) ? false : ((this.shapeFilter == null || "".equals(this.shapeFilter.trim())) ? true
                    : (this.shapeFilter.equals(f.getShape()))));

            return result;
        }

        private void populateData(final Session s, final Database db) {
            try {
                final View v = db.getView(FRUIT_VIEW);
                // You might need to loop a little here to get all the values
                final ViewEntryCollection vec = v.getAllEntriesByKey(s.getUserName());
                ViewEntry ve = vec.getFirstEntry();

                while (ve != null) {
                    ViewEntry nextVe = vec.getNextEntry(ve);
                    Fruit f = new Fruit(ve);
                    this.updateSelectors(f);
                    this.allFruits.add(f);
                    ve = nextVe;
                    nextVe.recycle();
                }

                vec.recycle();
                v.recycle();
            } catch (NotesException e) {
                // TODO Stacktrace is no error handling
                e.printStackTrace();
            }

        }

        private void updateSelectors(Fruit f) {
            this.colors.add(f.getColor());
            this.shape.add(f.getShape());
            this.taste.add(f.getTaste());
        }

    }