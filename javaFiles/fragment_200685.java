import javax.swing.*;
import java.awt.*;

public class TemplatesList extends JComboBox<String>
{
    private String[] lista = {"change", "handover"};


    public TemplatesList()
    {
        super(); //call JComboBox's constructor. This is standard practice
        for (int i=0; i < lista.length; i++)
        {
            this.addItem(lista[i]);
        }
    }
}