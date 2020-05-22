List<CharSequence> mHelperNames = new ArrayList<CharSequence>();
    mHelperNames.add("Test Item 1");
    mHelperNames.add("Test Item 2");

    final List<Integer> mSelectedItems = new ArrayList<Integer>();

    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("My Title")
            .setMultiChoiceItems(mHelperNames.toArray(new CharSequence[mHelperNames.size()]), null,
                    new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog,
                                int which, boolean isChecked) {
                            if (isChecked) {

                                mSelectedItems.add(which);
                            } else if (mSelectedItems.contains(which)) {

                                mSelectedItems.remove(Integer
                                        .valueOf(which));
                            }
                        }
                    })