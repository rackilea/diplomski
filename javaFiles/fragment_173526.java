MyImageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        OnFollowingClick click;
        click = new OnMyClick(param1, param2);  // irrelevant for this thread
        click.onClick(view);    // irrelevant for this thread

        // your solution is here!
        click.setCallback(new CallbackInterface() {
            @Override
            public void Callback() {
                System.out.println("Hey, you called.");
            }
        });
    }
});