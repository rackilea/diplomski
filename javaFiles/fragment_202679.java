public class UserPage extends BorderPane{

    TextField t1,t3,t4;
    ComboBox comboBox1;

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    public UserPage(){
      this.setTop(addHBox1());
      this.setRight(addVBox1());
      this.setLeft(addVBox2());
      this.setBottom(addHBox2());
    }

    //.... Your methods
}