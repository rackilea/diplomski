abstract class BigJavaBeanLoader {
    private final BigJavaBeanLoader successor;

    public BigJavaBeanLoader() {
        this.successor = null;
    }

    public BigJavaBeanLoader(BigJavaBeanLoader successor) {
        this.successor = successor;
    }

    public void loadData(BigJavaBean bean) {
        if (this.loadDataFromSource(bean) && this.successor != null) {
            this.successor.loadData(bean);
        }
    }

    protected abstract boolean loadDataFromSource(BigJavaBean bean);

    class DataBase extends BigJavaBeanLoader {
        @Override
        protected boolean loadDataFromSource(BigJavaBean bean) {
            // do a database stuff
            return true;
        }
    }

    class FlatFiles extends BigJavaBeanLoader {
        @Override
        protected boolean loadDataFromSource(BigJavaBean bean) {
            // do flat files stuff
            return true;
        }
    }

}

BigJavaBean bigJavaBean = new BigJavaBean();
BigJavaBeanLoader loader;
loader = new BigJavaBeanLoader.FlatFiles();
loader = new BigJavaBeanLoader.DataBase(loader);
loader.loadData(bebigJavaBean);