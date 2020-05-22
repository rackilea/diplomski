class View {
    ViewParent getParent() {
        return new ViewGroup() {
            @Override
            public ViewParent getParentView() {
                return null;
            }
        };
    }
}