package
{
public class ModelLocator{
    public static var instance:ModelLocator;

    public var editTimetableVO:*;

    public function ModelLocator(instance:SingletonEnforcer){}

    public static function getInstance():ModelLocator{
        if(!instance){
            instance = new ModelLocator(new SingletonEnforcer());
        }
        return instance;
    }
}

}class SingletonEnforcer{}

// sub1.mxml
[Bindable]private var model:ModelLocator = ModelLocator.getInstance();
    public function forwardToCreateEvent(event:MouseEvent):void
    {
        model.editTimetableVO = new TimetableVO();
        model.editTimetableVO=editDataGrid.selectedItem as     TimetableVO;//editDataGrid is DataGrid id
        Alert.show("value   "+model.editTimetableVO.startDate);
        }


// Sub2.mxml
[Bindable]private var model:ModelLocator = ModelLocator.getInstance();
    protected function init(event:FlexEvent):void
    {
        Alert.show("Show");
        model.timetableVO=myEditEvent.editDataGrid.selectedItem as TimetableVO;

        Alert.show("value "+model.timetableVO.startDate);

    }