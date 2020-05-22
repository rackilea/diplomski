private void updateText(int index)
{
    String text = null;

    switch (index)
    {
        case 0:
            text = "Selected";
            break;
        case 1:
            text = "Selected 2";
            break;
    }

    textArea.setText(text);
}