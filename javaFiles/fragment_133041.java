public void updateTextBox()
{
    if (jComboBox1.getSelectedIndex() == 0) //bowling
    {
        labelPic1.setIcon(imgIcons[0]);
        //Update textbox here to show results for item 0
    }
    else if (jComboBox1.getSelectedIndex() == 1) //lacrosse
    {
        labelPic1.setIcon(imgIcons[1]);
        //Update textbox here to show results for item 1
    }
}