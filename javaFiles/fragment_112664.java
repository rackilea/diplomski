public class PositionAction extends Action {
    private Vector2 target;

    public PositionAction(Vector2 target){
        super( ImpactType.Position );
        this.target= target;
    }
    ...
}