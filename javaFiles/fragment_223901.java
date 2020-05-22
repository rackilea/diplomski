class FullHeightGridView : GridView {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {}

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        if (adapter != null) {
            var i = 0
            while (i < childCount) {
                // Determine the maximum height for this row
                var maxHeight = 0

                for (j in i until i + numColumns) {
                    val view = getChildAt(j)
                    if (view != null && view.height > maxHeight) {
                        maxHeight = view.height
                    }
                }
                //Log.d(TAG, "Max height for row #" + i/numColumns + ": " + maxHeight);

                // Set max height for each element in this row
                if (maxHeight > 0) {
                    for (j in i until i + numColumns) {
                        val view = getChildAt(j)
                        if (view != null && view.height != maxHeight) {
                            view.minimumHeight = maxHeight
                        }
                    }
                }

                layoutParams.height = maxHeight

                i += numColumns
            }
        }
    }
}