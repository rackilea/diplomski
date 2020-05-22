Button addButton = (Button)customView2.findViewById(R.id.addButton);
            addButton.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View View2) {
                    EditText text = (EditText)customView2.findViewById(R.id.editText);

                    //This is where my java.lang.NullPointerException pops
                    String title = text.getText().toString();

                    taskList = Task.addTask(taskList, title);

                    mPopupWindow2.dismiss();

                }
            });