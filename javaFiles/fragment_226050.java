package micropaint;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author CarlosA.
 */
public class FXMLDocumentController implements Initializable {
    //>>>>>>>>>>>>>>>>>>>>>>>Other variables<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    private GraphicsContext gcB,gcF;
    private boolean drawline = false,drawoval = false,drawrectangle = false,erase = false,freedesign = true;
    double startX, startY, lastX,lastY,oldX,oldY;
    double hg;
    //>>>>>>>>>>>>>>>>>>>>>>>FXML Variables<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @FXML private RadioButton strokeRB,fillRB;
    @FXML private ColorPicker colorPick;
    @FXML private Canvas TheCanvas,canvasGo;
    @FXML private Button rectButton,lineButton,ovlButton,pencButton;
    @FXML private Slider sizeSlider;
    //////////////////////////////////////////////////////////////////////////////


    @FXML
    private void onMousePressedListener(MouseEvent e){
        this.startX = e.getX();
        this.startY = e.getY();
        this.oldX = e.getX();
        this.oldY = e.getY();
    }

    @FXML
    private void onMouseDraggedListener(MouseEvent e){
        this.lastX = e.getX();
        this.lastY = e.getY();

        if(drawrectangle)
            drawRectEffect();
        if(drawoval)
            drawOvalEffect();
        if(drawline)
            drawLineEffect();
        if(freedesign)
            freeDrawing();
    }

    @FXML
    private void onMouseReleaseListener(MouseEvent e){
        if(drawrectangle)
            drawRect();
        if(drawoval)
            drawOval();
        if(drawline)
            drawLine();
    }

    @FXML
    private void onMouseExitedListener(MouseEvent event)
    {
        System.out.println("No puedes dibujar fuera del canvas");
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>Draw methods<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    private void drawOval()
    {
        double wh = lastX - startX;
        double hg = lastY - startY;
        gcB.setLineWidth(sizeSlider.getValue());

        if(fillRB.isSelected()){
            gcB.setFill(colorPick.getValue());
            gcB.fillOval(startX, startY, wh, hg);
        }else{
            gcB.setStroke(colorPick.getValue());
            gcB.strokeOval(startX, startY, wh, hg);
        }
    }

    private void drawRect()
    {
        double wh = lastX - startX;
        double hg = lastY - startY;
        gcB.setLineWidth(sizeSlider.getValue());

        if(fillRB.isSelected()){
            gcB.setFill(colorPick.getValue());
            gcB.fillRect(startX, startY, wh, hg);
        }else{
            gcB.setStroke(colorPick.getValue());
            gcB.strokeRect(startX, startY, wh, hg);
        }
    }

    private void drawLine()
    {
        gcB.setLineWidth(sizeSlider.getValue());
        gcB.setStroke(colorPick.getValue());
        gcB.strokeLine(startX, startY, lastX, lastY);
    }

    private void freeDrawing()
    {
        gcB.setLineWidth(sizeSlider.getValue());
        gcB.setStroke(colorPick.getValue());
        gcB.strokeLine(oldX, oldY, lastX, lastY);
        oldX = lastX;
        oldY = lastY;
    }

    //////////////////////////////////////////////////////////////////////
    //>>>>>>>>>>>>>>>>>>>>>>>>>>Draw effects methods<<<<<<<<<<<<<<<<<<<<<<<

    private void drawOvalEffect()
    {
        double wh = lastX - startX;
        double hg = lastY - startY;
        gcF.setLineWidth(sizeSlider.getValue());

        if(fillRB.isSelected()){
            gcF.clearRect(0, 0, canvasGo.getWidth(), canvasGo.getHeight());
            gcF.setFill(colorPick.getValue());
            gcF.fillOval(startX, startY, wh, hg);
        }else{
            gcF.clearRect(0, 0, canvasGo.getWidth(), canvasGo.getHeight());
            gcF.setStroke(colorPick.getValue());
            gcF.strokeOval(startX, startY, wh, hg );
        }
       }

    private void drawRectEffect()
    {
        double wh = lastX - startX;
        double hg = lastY - startY;
        gcF.setLineWidth(sizeSlider.getValue());

        if(fillRB.isSelected()){
            gcF.clearRect(0, 0, canvasGo.getWidth(), canvasGo.getHeight());
            gcF.setFill(colorPick.getValue());
            gcF.fillRect(startX, startY, wh, hg);
        }else{
            gcF.clearRect(0, 0, canvasGo.getWidth(), canvasGo.getHeight());
            gcF.setStroke(colorPick.getValue());
            gcF.strokeRect(startX, startY, wh, hg );
        }
    }

    private void drawLineEffect()
    {
        gcF.setLineWidth(sizeSlider.getValue());
        gcF.setStroke(colorPick.getValue());
        gcF.clearRect(0, 0, canvasGo.getWidth() , canvasGo.getHeight());
        gcF.strokeLine(startX, startY, lastX, lastY);
    }
    ///////////////////////////////////////////////////////////////////////

    @FXML 
    private void clearCanvas(ActionEvent e)
    {
        gcB.clearRect(0, 0, TheCanvas.getWidth(), TheCanvas.getHeight());
        gcF.clearRect(0, 0, TheCanvas.getWidth(), TheCanvas.getHeight());
    }


    //>>>>>>>>>>>>>>>>>>>>>Buttons control<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @FXML
    private void setOvalAsCurrentShape(ActionEvent e)
    {
        drawline = false;
        drawoval = true;
        drawrectangle = false;
        freedesign = false;
        erase = false;
    }

     @FXML
    private void setLineAsCurrentShape(ActionEvent e)
    {
        drawline = true;
        drawoval = false;
        drawrectangle = false;
        freedesign = false;
        erase = false;
    }
     @FXML
    private void setRectangleAsCurrentShape(ActionEvent e)
    {
        drawline = false;
        drawoval = false;
        freedesign = false;
        erase=false;
        drawrectangle = true;
    }

    @FXML
    private void setErase(ActionEvent e)
    {
        drawline = false;
        drawoval = false;
        drawrectangle = false;    
        erase = true;
        freedesign= false;
    }

    @FXML
    private void setFreeDesign(ActionEvent e)
    {
        drawline = false;
        drawoval = false;
        drawrectangle = false;    
        erase = false;
        freedesign = true;
    }

    //////////////////////////////////////////////////////////////////


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gcB = TheCanvas.getGraphicsContext2D();
        gcF = canvasGo.getGraphicsContext2D();

        sizeSlider.setMin(1);
        sizeSlider.setMax(50);

        //////////////////////////////////
        Image imageRect = new Image(getClass().getResourceAsStream("Stop-32.png"));
        ImageView icR = new ImageView(imageRect);
        icR.setFitWidth(32);
        icR.setFitHeight(32);
        rectButton.setGraphic(icR);  

        Image imageLinea = new Image(getClass().getResourceAsStream("Ruler-32.png"));
        ImageView icLin = new ImageView(imageLinea);
        icLin.setFitWidth(32);
        icLin.setFitHeight(32);
        lineButton.setGraphic(icLin);

        Image imageOvalo = new Image(getClass().getResourceAsStream("Chart-32.png"));
        ImageView icOval = new ImageView(imageOvalo);
        icOval.setFitWidth(32);
        icOval.setFitHeight(32);
        ovlButton.setGraphic(icOval);

        Image imageLapiz = new Image(getClass().getResourceAsStream("Pencil-32.png"));
        ImageView icLapiz = new ImageView(imageLapiz);
        icLapiz.setFitWidth(32);
        icLapiz.setFitHeight(32);
        pencButton.setGraphic(icLapiz);
    }    

}