/**
 * Make a DataModel out of an Iterator that may be used with JSF's ui:repeat tag
 *
 * This DataModel does not support the use of offset or step attributes in the
 * ui:repeat tag, and the size attribute in ui:repeat, when used with this DataModel, 
 * will report an inaccurate value.
 *
 * Copyright (c) 2014 Woldrich, Inc.
 * Licensed under MIT (https://clubcompy.com/wcm/license/mit.txt)
 * 
 * @author Dave Woldrich
 */
public class IteratorDataModel<T> extends DataModel<T> {
    private static final Logger logger = LogManager.getLogger(IteratorDataModel.class);

    private Iterator<?> iterator;
    private int rowIndex; 
    private T item;

    public IteratorDataModel(Iterator<?> iterator) {
        setWrappedData(iterator);      
    }

    @Override
    public int getRowCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public T getRowData() {
        return this.item;
    }

    @Override
    public int getRowIndex() {
        if(this.rowIndex == -1 && this.iterator.hasNext()) {
            this.setRowIndex(0);
        }

        if(logger.isTraceEnabled()) {
            logger.trace("getRowIndex returns " + this.rowIndex);
        }

        return this.rowIndex;
    }

    @Override
    public Object getWrappedData() {
        return this.iterator;
    }

    @Override
    public boolean isRowAvailable() {
        boolean hasNext = this.item != null || this.iterator.hasNext(); 

        if(logger.isTraceEnabled()) {
            logger.trace("isRowAvailable " + hasNext);
        }

        return hasNext;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setRowIndex(int newIndex) {
        if(logger.isTraceEnabled()) {
            logger.trace("setRowIndex (" + newIndex + ")");
        }

        if(newIndex == this.rowIndex+1) {
            this.rowIndex = newIndex;

            this.item = (T) (this.iterator.hasNext() ? this.iterator.next() : null);
        } 
        else if(newIndex > -1 || newIndex != this.rowIndex) {
            if(logger.isTraceEnabled()) {
                logger.trace("setRowIndex not incrementing by 1 as expected, ignored");            
            }
        }
    }

    @Override
    public void setWrappedData(Object data) {
        this.iterator = (Iterator<?>) data;
        this.rowIndex = -1;
        this.item = null;
    }    
}