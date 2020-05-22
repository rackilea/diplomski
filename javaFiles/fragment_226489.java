86     public Dimension preferredLayoutSize(Container parent) {
   87         Component view = ((JViewport)parent).getView();
   88         if (view == null) {
   89             return new Dimension(0, 0);
   90         }
   91         else if (view instanceof Scrollable) {
   92             return ((Scrollable)view).getPreferredScrollableViewportSize();
   93         }
   94         else {
   95             return view.getPreferredSize();
   96         }
   97     }