import com.sun.javafx.scene.control.skin.PaginationSkin;
import javafx.event.EventHandler;
import javafx.scene.control.Pagination;
import javafx.scene.input.KeyEvent;

class ProtocolPaginationSkin extends PaginationSkin implements EventHandler<KeyEvent> {

    public ProtocolPaginationSkin(Pagination pagination) {
        super(pagination);
        pagination.setOnKeyPressed(this);
    }

    @Override
    public void selectNext() {
        if (getSkinnable().getCurrentPageIndex() < getSkinnable().getPageCount() - 1) {
            validateAndSave(getSkinnable().getCurrentPageIndex() + 1);
        }
    }

    @Override
    public void selectPrevious() {
        if (getSkinnable().getCurrentPageIndex() > 0) {
            validateAndSave(getSkinnable().getCurrentPageIndex() - 1);
        }
    }

    @Override
    public void handle(KeyEvent event) {
        if (event.getCode().isDigitKey()) {
            int index = Integer.parseInt(event.getText()) - 1;
            if (index >= 0 && index < getSkinnable().getPageCount()) {
                validateAndSave(index);
            }
        }
    }

    private void validateAndSave(int index) {
        if (isPageValid() && save()){
            getSkinnable().setCurrentPageIndex(index);
        }
    }
}