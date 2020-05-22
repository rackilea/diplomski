TableModel model = table.getModel();
int easyQuestions = 0;

for (int i = 0; i < model.getRoWCount(); i++)
{
    String level = (String)model.getValueAt(i, 2);

    if ("Easy".equals(level))
        easyQuestion++;

    // repeat for medium and difficult
}

System.out.println( easyQuestions );