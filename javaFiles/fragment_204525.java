public void actionPerformed(ActionEvent e)
{
    int result = EditValuationsDialog.showDialog();
}

public class EditValuationsDialog ... {
    //...
    private int result = -1;
    //...
    public int getResult() {
        return result;
    }
    //...
    public static int showDialog(Component source, int rowNum, Object valueAt) {

        EditValuationsDialog edit = null;
        Window parent = SwingUtilities.windowFor(source);
        if (parent instanceof Frame) {
            edit = new EditValuationsDialog((Frame)parent,true);
        } else if (parent instanceof Dialog) {
            edit = new EditValuationsDialog((Dialog)parent,true);
        } else {
            edit = new EditValuationsDialog(null,true);
        }

        edit.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        edit.setTitle("Edit Valuations");
        edit.setClientName(portfolioViewClientName.getText());
        edit.setPortfolioType(portfolioViewInvestmentTypeCombo.getSelectedItem().toString());
        edit.setPortfolioId(id);
        edit.setOngoingValuationsId(Integer.parseInt(String.valueOf(valueAt)));
        edit.setLocationRelativeTo(source);
        edit.setVisible(true);

        return edit.getResult();
    }
    //...
    private class AddBtnAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(someCondition)
            {
                result = 0;
            }
            else
            {
                result = 1;
            }
            EditValuationsDialog.this.dispose();
        }
    }
}