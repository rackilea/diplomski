private List<SimpleViewModel> models = new ArrayList<>();
private onItemClickListener mListener;

public SimpleAdapter(final List<SimpleViewModel> viewModels)
{
    if (viewModels != null) {
        this.models.addAll(viewModels);
    }
}