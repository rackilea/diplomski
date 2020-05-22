class MyDialogFragment : DialogFragment() {                   

    override fun onCreateDialog(savedInstanceState: Bundle?)  
            : Dialog {                                        

        return object : Dialog(activity, theme){              

            override fun onTouchEvent(event: MotionEvent?)    
                    : Boolean {                               
                // Here you can handle the touch event        
                return super.onTouchEvent(event)              
            }                                                 
        }                                                     
    }                                                         
}