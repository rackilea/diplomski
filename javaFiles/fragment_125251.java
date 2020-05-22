onFinishListener mListener; // Create a variable for your interface

// Define the interface & callbacks
public interface onFinishListener{
    // Replace 'variableType' with the appropriate type for your result
    void onFinish(variableType myResult);
}

public void setOnFinishListener(onFinishListener l){
    mListener = l;
}

@Override
protected void onPostExecute(variableType result){
    if(mListener != null){
        mListener.onFinish(result);
    }
}