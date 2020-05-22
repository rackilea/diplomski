public class SpinnerImpl extends Composite implements Spinner.View{
    private TextBox txtBox;
    private Button upButton,downButton;
    private HorizontalPanel panel;
    private SpinnerPresenter presenter;
    public SpinnerImpl(SpinnerPresenter presenter){
        this.presenter = presenter;
        upButton = new Button("up");
        downButton = new Button("down");

        txtBox = new TextBox();
        txtBox.setEnabled(false);

        panel = new HorizontalPanel();
        panel.add(upButton);
        panel.add(txtBox);
        panel.add(downButton);

        addHandlers();
        initWidget(panel);      
    }   
    private void addHandlers() {
        upButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                presenter.upButtonClicked();
            }
        });
        downButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                presenter.downButtonClicked();
            }
        });     
    }
    @Override
    public void stepDown(int step) {
        txtBox.setValue(Integer.parseInt(txtBox.getValue())-1+"");
    }
    @Override
    public void stepUp(int step) {
        txtBox.setValue(Integer.parseInt(txtBox.getValue())+1+"");
    }
    @Override
    public void setValue(int value) {
        txtBox.setValue(0+"");
    }
}