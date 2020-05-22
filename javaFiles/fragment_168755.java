override fun onEditTextTouch(editText: EditText, event: MotionEvent): Boolean {
    //-- if the pressed gesture has finished
    if (event.action == MotionEvent.ACTION_UP)
    //-- only show toast if view is not editable (becomes editable on LongClick)
        if (editText.keyListener == null) {
            if (mToast != null) {
                mToast!!.cancel()
            }
            //-- inform user to long press to edit entry
            mToast = Toast.makeText(this, resources.getString(R.string.long_click_to_edit), Toast.LENGTH_LONG)
            mToast!!.show()
        }
    return false
}