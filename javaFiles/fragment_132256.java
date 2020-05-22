int selectedCount = 0; // Global variable

@Override
public void checkboxListener(boolean isSelected){
    if (isSelected)
        selectedCount++;
    else
        selectedCount--;
    if (selectedCount > 0)
        button.setEnabled(true);
    else
        button.setEnabled(false);
}