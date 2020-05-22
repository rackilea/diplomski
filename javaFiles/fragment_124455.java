class Example {
    Button button = new SomeButton();

    public void example() {
        button.setOnClickListener(new OnClickListener() {
            public void onClick(SomeClickEvent clickEvent) {
                System.out.println("A click happened at " + clickEvent.getClickTime());
            }
        });
    }

    interface OnClickListener {
        void onClick(SomeClickEvent clickEvent);
    }

    interface Button {
        void setOnClickListener(OnClickListener ocl);
    }
}