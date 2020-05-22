/** 
* This interface is adopted by an object that mediates
* the application’s data model for a SpaceView object. 
*/
public interface SpaceViewDataSource {
    List<Pawn> getPawns();
    Card getCard()
    ...
}