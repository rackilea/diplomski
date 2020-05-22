expListView.setOnChildClickListener(new ExpandableListView
        .OnChildClickListener() {
    @Override
    public boolean onChildClick(ExpandableListView elv, View view, int i,
                                int i2, long l) {
        TextView tv = view.findViewById(R.id.name);
        String name = (String) tv.getText();
        try {
            // Change package.name to your package
            Class cls = Class.forName("package.name." + name);
            Intent intent = new Intent(MainActivity.this, cls);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
});