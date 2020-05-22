@FXML
public void clickItem(MouseEvent event)
{
    if (event.getClickCount() == 2) //Checking double click
    {
        System.out.println(tableID.getSelectionModel().getSelectedItem().getBeer());
        System.out.println(tableID.getSelectionModel().getSelectedItem().getBrewery());
        System.out.println(tableID.getSelectionModel().getSelectedItem().getCountry());
    }
}