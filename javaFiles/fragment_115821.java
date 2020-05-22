public class DnDToMoveData{
    double pressPositionX;
    double pressPositionY;

    DnDToMoveData(Data<Number, Number> data){
        data.getNode().setOnMousePressed(event->{
            pressPositionX = event.getSceneX();
            pressPositionY = chart.getHeight()-event.getSceneY();  
        });

        data.getNode().setOnMouseDragged(event->{
            data.setXValue(data.getXValue().doubleValue()+event.getSceneX())
            this.pressPositionX);
            data.setYValue(data.getYValue().doubleValue()+event.getSceneY())-this.pressPositionY);

            pressPositionX = event.getSceneX();
            pressPositionY = chart.getHeight()-event.getSceneY();
         });
    }
}