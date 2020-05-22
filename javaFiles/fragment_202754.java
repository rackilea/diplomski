public class MergerElementTagProcessor extends AbstractElementModelProcessor {

    private static final String TAG_NAME = "merger";

    public MergerElementTagProcessor(final String dialectPrefix) {
        super(TemplateMode.HTML, dialectPrefix, TAG_NAME, true, null, false, 1000);
    }

    @Override
    protected void doProcess(ITemplateContext context, IModel model,
            IElementModelStructureHandler structureHandler) {

        IProcessableElementTag tag = processElementTag(context, model);  // convert IModel to IProcessableElementTag
        Map<String, String> attrMap = processAttribute(context, tag); // get attributes of tag

        IModel baseModelClone = model.cloneModel(); // clone base model
        IModel fragmentModel = (IModel) computeFragment(context, tag.getAttributeValue("mergefragment")); // get fragment as IModel

        model.reset(); // clear the model reference
        model.addModel(mergeModel(fragmentModel, baseModelClone, "<my:content/>")); // merge the two IModels
    }

    protected IModel mergeModel(IModel fragment, IModel body, final String replaceTag) {
        IModel mergedModel = insert(fragment, body, replaceTag);
        mergedModel = remove(mergedModel, replaceTag);
        mergedModel = remove(mergedModel, replaceTag);
        return mergedModel;
    }

    private IModel insert(IModel fragment, IModel body, final String replaceTag) {
        IModel mergedModel = fragment.cloneModel();
        int size = mergedModel.size();
        ITemplateEvent event = null;
        for (int i = 0; i < size; i++) {
            event = mergedModel.get(i);
            if (event instanceof IOpenElementTag) {
                if (event.toString().contains(replaceTag)) {
                    mergedModel.insertModel(i, body);
                    break;
                }
            }
        }
        return mergedModel;
    }

    private IModel remove(IModel fragment, final String replaceTag) {
        IModel mergedModel = fragment.cloneModel();
        int size = mergedModel.size();
        ITemplateEvent event = null;
        for (int i = 0; i < size; i++) {
            event = mergedModel.get(i);
            if (event instanceof IOpenElementTag || event instanceof ICloseElementTag) {
                if (event.toString().contains(replaceTag)) {
                    mergedModel.remove(i);
                    break;
                }
            }
        }
        return mergedModel;
    }

}