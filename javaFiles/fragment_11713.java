if (Problem != null && (!notokcheckbox.isChecked() && !ressolvedcheckbox.isChecked())) {
    Toast.makeText(getActivity(), "Enable Ok Or Not/Ok", 100000)
        .show();
} 
else {
    Toast.makeText(getActivity(), "Sucess", 100000)
        .show();
}