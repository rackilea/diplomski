public interface SubmitListener {

    void onSubmit();
}

private SubmitListener onSubmitListener;

public void setSubmitListener(SubmitListener onSubmitListener){
        this.onSubmitListener = onSubmitListener;
}

public SubmitListener getOnSubmitListener(){
        return onSubmitListener;
}