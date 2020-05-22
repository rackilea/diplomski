import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class SearchPage extends JFrame {

    private JTextField searchField;
    private JButton searchButton;
    private ItemPage itemPage;

    SearchPage(){
        setSize(200,100);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        searchField = new JTextField(9);
        add(searchField, BorderLayout.NORTH);

        searchButton = new JButton("Search");
        searchButton.addActionListener(e -> {

            String searchFor = searchField.getText();
            if ((searchFor != null) && ! searchFor.isEmpty()) {
                itemPage.search(searchFor);
            }
        });
        add(searchButton, BorderLayout.SOUTH);
        itemPage = new ItemPage();
        setVisible(true);
    }

    public static void main(String[] args)  {
        new SearchPage();
    }
}

class ItemPage {

    public void search(String searchFor) {
        System.out.println("Searching for "+ searchFor);
    }
}