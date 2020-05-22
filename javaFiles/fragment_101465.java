@Override
public void initialize(URL url, ResourceBundle rb)
{
    Image image = new Image(getClass().getResourceAsStream("/images/cards/Ad.png"));
    card.setFitHeight(100); //726
    card.setFitWidth(200); //500
    card.setImage(image);
}