public Questions()
{
    for (int i = 0; i < solution.length; i++)
    {
        solution[i] = colors[r.nextInt(10)];
    }

    JOptionPane.showMessageDialog(null,"How good is your memory?\nTry to memorize this color sequence:\n"+solution);

    createContents();

    mainwindow.setVisible(true);
}