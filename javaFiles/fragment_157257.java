NamVyuVar.setOnTouchListener(new View.OnTouchListener()
{
    @Override
    public boolean onTouch(View view, MotionEvent MsnEvtPsgVar)
    {
        switch (MsnEvtPsgVar.getActionMasked())
        {
            case MotionEvent.ACTION_DOWN:
                Log.d("TAG", "onTouch: ACTION_DOWN");
                break;

            case MotionEvent.ACTION_MOVE:
                LinearLayout NamLloVav = (LinearLayout)view;
                float SubVyuHytVal = NamLloVav.getChildAt(0).getHeight();
                float TchPntYcoVal = MsnEvtPsgVar.getY();
                int NamIdxVal = (int) (TchPntYcoVal / SubVyuHytVal);

                View NamIdxVyuVav = NamLloVav.getChildAt(NamIdxVal)

            // CodTodo With the Indexed View NamIdxVyuVav :

                break;

            case MotionEvent.ACTION_UP:
                Log.d("TAG", "onTouch: ACTION_UP");
                break;
        }
        return true;
    }
});