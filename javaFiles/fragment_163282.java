public class SnapHelperExt {

    public SnapHelperExt(){}

    public int getSnapPosition(RecyclerView recyclerView, SnapHelper snapHelper){
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        View snapView =  snapHelper.findSnapView(layoutManager);
        if (snapView != null) {
            return layoutManager.getPosition(snapView);
        }else{
            return -1;
        }
    }
}