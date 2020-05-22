import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.util.*;

public class ComboBoxTable
{
  public static void main(String[] args)
  {
    // Mock data source
    DataSource dataSource = new DataSource();

    JComboBox<String> seriesComboBox = new JComboBox<>();
    for (String s : dataSource.getSeries())
    {
      seriesComboBox.addItem(s);
    }

    JTable table = new JTable(
        new String[][] {{"", ""}, {"", ""}, {"", ""}},
        new String[] {"Series", "Episode"});
    table.getColumn("Series").setCellEditor(new DefaultCellEditor(seriesComboBox));
    table.getColumn("Episode").setCellEditor(new EpisodeEditor(dataSource));

    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().add(new JScrollPane(table));
    f.setBounds(300, 200, 400, 300);
    f.setVisible(true);
  }
}

class EpisodeEditor extends AbstractCellEditor implements TableCellEditor
{
  private DataSource dataSource;
  private JComboBox<String> episodesComboBox = new JComboBox<>();

  EpisodeEditor(DataSource dataSource)
  {
    this.dataSource = dataSource;
  }

  @Override
  public java.awt.Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
                                                        int row, int column)
  {
    String series = (String) table.getModel().getValueAt(row, 0);

    List<String> episodes = dataSource.getEpisodes(series);
    episodesComboBox.removeAllItems();
    for (String ep : episodes)
    {
      episodesComboBox.addItem(ep);
    }
    episodesComboBox.setSelectedItem(value);
    return episodesComboBox;
  }

  @Override
  public Object getCellEditorValue()
  {
    return episodesComboBox.getSelectedItem();
  }
}

class DataSource
{
  List<String> getSeries()
  {
    return Arrays.asList("Prison Break", "Breaking Bad", "Pokemon");
  }

  List<String> getEpisodes(String series)
  {
    switch (series)
    {
      case "Prison Break":
        return Arrays.asList("Break 1", "Break 2", "Break 3");
      case "Breaking Bad":
        return Arrays.asList("Bad 1", "Bad 2", "Bad 3");
      case "Pokemon":
        return Arrays.asList("P1", "P2", "P3");
      default:
        throw new IllegalArgumentException("Invalid series: " + series);
    }
  }
}