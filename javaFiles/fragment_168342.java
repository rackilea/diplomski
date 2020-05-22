try{
    Fragment onInputSelected_Fragment = getTargetFragment();
    Activity onInputSelected_Activity = getActivity();
    if (onInputSelected_Fragment != null){
        onInputSelected = (OnInputSelected)onInputSelected_Fragment;
    }
    else {
        onInputSelected = (OnInputSelected)onInputSelected_Activity;
    }
    // throw RuntimeException here if onInputSelected still is null
    //
}catch(ClassCastException e){
    Log.e("Custom Dialog", "onAttach: ClassCastException: " + e.getMessage());
}