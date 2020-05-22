import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class TestJTable {

    public static void main(String[] args) {
        new TestJTable();
    }

    public TestJTable() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                List<Pet> pets = new ArrayList<>(25);
                pets.add(new Pet("Tyrannosauridae", "TYRANNOSAURUS", 20, 35));
                pets.add(new Pet("Dromaeosauridae", "VELOCIRAPTOR", 45, 90));
                pets.add(new Pet("Ceratopsidae", "TRICERATOPS", 15, 30));
                pets.add(new Pet("Stegosauridae", "STEGOSAURUS", 22, 25));
                pets.add(new Pet("Titanosauridae", "MALAWISAURUS", 22, 25));
                pets.add(new Pet("Compsognathidae", "COMPSOGNATHUS", 8, 25));
                pets.add(new Pet("Brachiosauridae", "BRACHIOSAURUS", 8, 25));
                pets.add(new Pet("Diplodocidae", "DIPLODOCUS", 8, 25));

                final PetTableModel model = new PetTableModel(pets);
                final JTable table = new SpringTable(model);

                InputMap im = table.getInputMap(JTable.WHEN_FOCUSED);
                ActionMap am = table.getActionMap();
                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "delete");
                am.put("delete", new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int[] indicies = table.getSelectedRows();
                        int[] mapped = new int[indicies.length];
                        for (int index = 0; index < indicies.length; index++) {
                            mapped[index] = table.convertRowIndexToModel(indicies[index]);
                        }
                        model.removePets(mapped);
                    }
                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class SpringTable extends JTable {

        public SpringTable(TableModel dm) {
            super(dm);
            setAutoResizeMode(AUTO_RESIZE_OFF);
        }

        public SpringTable() {
            setAutoResizeMode(AUTO_RESIZE_OFF);
        }

        @Override
        public void doLayout() {
            int width = getWidth();
            int columnCount = getColumnCount();
            int columnSize = width / columnCount;
            for (int index = 0; index < columnCount; index++) {
                TableColumn column = getColumnModel().getColumn(index);
                column.setResizable(false);
                column.setPreferredWidth(width);
            }
            super.doLayout();
        }

        @Override
        public boolean getScrollableTracksViewportWidth() {
            return true;
        }

    }

    public class PetTableModel extends AbstractTableModel {

        private List<Pet> pets;

        public PetTableModel() {
            pets = new ArrayList<>(25);
        }

        public PetTableModel(List<Pet> pets) {
            this.pets = pets;
        }

        @Override
        public int getRowCount() {
            return pets.size();
        }

        public void removePets(int... indicies) {
            List<Pet> old = new ArrayList<>(indicies.length);
            for (int index : indicies) {
                old.add(pets.get(index));
            }

            for (Pet pet : old) {
                int index = pets.indexOf(pet);
                pets.remove(pet);
                fireTableRowsDeleted(index, index);
            }
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            Class clazz = String.class;
            switch (columnIndex) {
                case 2:
                case 3:
                    clazz = Float.class;
            }
            return clazz;
        }

        @Override
        public String getColumnName(int column) {
            String name = "??";
            switch (column) {
                case 0:
                    name = "Breed";
                    break;
                case 1:
                    name = "Category";
                    break;
                case 2:
                    name = "Buy Price";
                    break;
                case 3:
                    name = "Sell Price";
                    break;
            }
            return name;
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Pet pet = pets.get(rowIndex);
            Object value = null;
            switch (columnIndex) {
                case 0:
                    value = pet.getBreed();
                    break;
                case 1:
                    value = pet.getCategory();
                    break;
                case 2:
                    value = pet.getBuyPrice();
                    break;
                case 3:
                    value = pet.getSellPrice();
                    break;
            }
            return value;
        }

        public void add(Pet pet) {
            pets.add(pet);
            fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
        }

    }

    public class Pet {

        private String breed;
        private String category; 
        private float buyPrice; 
        private float sellPrice; 

        public Pet(String breed, String category, float buyPrice, float sellPrice) {
            this.breed = breed;
            this.category = category;
            this.buyPrice = buyPrice;
            this.sellPrice = sellPrice;
        }

        public String getBreed() {
            return breed;
        }

        public float getBuyPrice() {
            return buyPrice;
        }

        public String getCategory() {
            return category;
        }

        public float getSellPrice() {
            return sellPrice;
        }

    }

}