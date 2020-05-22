public class PieMaximumLabelsGenerator extends StandardPieSectionLabelGenerator {

    private static final long serialVersionUID = 1385777973353453096L;
    private int nrLabels;
    private boolean showFirst;

    /**
     * A custom label generator to show only limited numbers of labels
     * @param nrLabels, number of labels to show
     * @param showFirst, if true, show first labels otherwise show the last
     */
    public PieMaximumLabelsGenerator(int nrLabels, boolean showFirst){
        this.nrLabels = nrLabels;
        this.showFirst = showFirst;

    }

    @Override
    public String generateSectionLabel(PieDataset dataset, Comparable key) {
        int index = dataset.getIndex(key);
        if (showFirst){
            if (index>=nrLabels){
                return null; //no more lables if index is above
            }
        }else{
            if (index<dataset.getItemCount()-nrLabels){
                return null; //no labels if index is not enough
            }
        }
        return super.generateSectionLabel(dataset, key);
    }
}