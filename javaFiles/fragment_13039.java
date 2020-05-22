import com.jidesoft.combobox.PopupPanel;
import com.jidesoft.grid.AutoFilterBox;
import com.jidesoft.grid.AutoFilterTableHeader;
import com.jidesoft.grid.AutoFilterTableHeaderEditor;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;
import java.awt.*;

public class AutoFilterPopSize extends AutoFilterTableHeader
{
    public AutoFilterPopSize(JTable table)
    {
        super(table);
    }

    @Override
    protected TableCellEditor createDefaultEditor()
    {
        if (isAutoFilterEnabled())
        {
            return new AutoFilterTableHeaderEditor()
            {
                @Override
                protected AutoFilterBox createAutoFilterBox()
                {
                    return new AutoFilterBox()
                    {
                        @Override
                        protected PopupPanel createPopupPanel(TableModel tableModel, int columnIndex, Object[] possibleValues)
                        {
                            PopupPanel panel = super.createPopupPanel(tableModel, columnIndex, possibleValues);
                            panel.setStretchToFit(false);
                            int wdth = columnModel.getColumn(columnIndex).getWidth();
                            panel.setPreferredSize(new Dimension(wdth, 400));
                            return panel;
                        }
                    };
                }
            };
        }
        else {
            return null;
        }
    }
}