class CustomTagWorkerFactory extends DefaultTagWorkerFactory {
@Override
public ITagWorker getCustomTagWorker(IElementNode tag, ProcessorContext context) {
    if (tag.name().equals("input")) {
        if (AttributeConstants.CHECKBOX.equals(tag.getAttribute(AttributeConstants.TYPE))) {
            return new AcroInputTagWorker(tag, context);
        }
    }
    return null;
}