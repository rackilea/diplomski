// The index of the last (possibly only partially) visible line of the widget
int bottomIndex = JFaceTextUtil.getPartialBottomIndex((StyledText)widget);
// The index of the first (possibly only partially) visible line of the widget
int topIndex = JFaceTextUtil.getPartialTopIndex((StyledText)widget);


int visibleLines = bottomIndex - topIndex;