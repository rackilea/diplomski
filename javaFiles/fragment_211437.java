package test;

    import java.io.Serializable;
    import java.util.Vector;

    import lotus.domino.Database;
    import lotus.domino.Document;
    import lotus.domino.NotesException;
    import lotus.domino.ViewEntry;

    public class Fruit implements Serializable {

        private static final long   serialVersionUID    = 1L;

        private String              name;
        private String              color;
        private String              shape;
        private String              taste;
        private String              unid                = null;

        public Fruit() {
            // default constructor, might not be needed
        }

        // To make it easy from a view
        public Fruit(final ViewEntry ve) {
            try {
                @SuppressWarnings("rawtypes")
                Vector v = ve.getColumnValues();
                // 0 would be the user/group/role
                this.setName(v.get(1).toString());
                this.setColor(v.get(2).toString());
                this.setShape(v.get(3).toString());
                this.setTaste(v.get(4).toString());
                this.unid = ve.getUniversalID();
            } catch (NotesException e) {
                e.printStackTrace();
            }

        }

        public void save(Database db) throws NotesException {
            Document doc;
            if (this.unid == null) {
                doc = db.createDocument();
            } else {
                doc = db.getDocumentByUNID(this.unid);
            }
            doc.replaceItemValue("Color", this.getColor());
            // more here
            doc.save();
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String name) {
            this.name = name;
        }

        public final String getColor() {
            return this.color;
        }

        public final void setColor(String color) {
            this.color = color;
        }

        public final String getShape() {
            return this.shape;
        }

        public final void setShape(String shape) {
            this.shape = shape;
        }

        public final String getTaste() {
            return this.taste;
        }

        public final void setTaste(String taste) {
            this.taste = taste;
        }
    }