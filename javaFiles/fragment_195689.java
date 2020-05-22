public class WaitForReset implements Condition
{

    public boolean isSatisfied()
    {
        TextView views = (TextView) solo.getView(R.id.textViewsNum);
        TextView prompts = (TextView) solo.getView(R.id.textPromptsNum);
        TextView completions = (TextView) solo.getView(R.id.textCompleteNum);
        if(isViewZero(views) && isViewZero(prompts) && isViewZero(completions))
        {
            return true
        }
        else
        {
            return false;
        }
    }

    private isViewZero(TextView textView)
    {
        if((textView!=null) && (textView.getText().toString() ==0))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}