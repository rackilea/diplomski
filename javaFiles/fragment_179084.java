import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.cgtag.R;

/**
 * This class positions child Views in a grid pattern, and allows some Views to
 * span across more then one grid cell.
 * <p>
 * The layout works by absolutely position each child in a row/column position.
 * As each child is positioned next to it's sibling the layout keeps track of
 * the depth for that column. This is used to fill holes that are created by
 * larger Views.
 */
public class TilesLayout extends ViewGroup
{
    private static String   TAG = TilesLayout.class.getName();

    /**
     * The parameters for this layout.
     */
    public static class LayoutParams extends ViewGroup.LayoutParams
    {
        /**
         * Number of Rows to span.
         */
        private int _row_span;

        /**
         * Number of Columns to span.
         */
        private int _column_span;

        /**
         * X location after measurements.
         */
        private int _x;

        /**
         * Y location after measurements.
         */
        private int _y;

        /**
         * Width of the child after measurements.
         */
        private int _width;

        /**
         * Height of the child after measurements.
         */
        private int _height;

        /**
         * @return the row_span
         */
        public int getRowSpan()
        {
            return _row_span;
        }

        /**
         * @param row_span
         *            the row_span to set
         */
        public void setRowSpan(int row_span)
        {
            this._row_span = Math.max(1, row_span);
        }

        /**
         * @return the column_span
         */
        public int getColumnSpan()
        {
            return _column_span;
        }

        /**
         * @param column_span
         *            the column_span to set
         */
        public void setColumnSpan(int column_span)
        {
            this._column_span = Math.max(1, column_span);
        }

        /**
         * Constructor
         */
        public LayoutParams()
        {
            super(0, 0);
            Init();
        }

        /**
         * Constructor
         *
         * @param context
         *            The view context.
         * @param attrs
         *            The attributes to read.
         */
        public LayoutParams(Context context, AttributeSet attrs)
        {
            super(context, attrs);
            Init();

            TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TilesLayout_Layout, 0, 0);
            try
            {
                setRowSpan(a.getInt(R.styleable.TilesLayout_Layout_row_span, 1));
                setColumnSpan(a.getInt(R.styleable.TilesLayout_Layout_column_span, 1));
            }
            finally
            {
                a.recycle();
            }
        }

        /**
         * Width/Height constructor
         *
         * @param w
         * @param h
         */
        public LayoutParams(int w, int h)
        {
            super(w, h);
            Init();
        }

        /**
         * Set default values.
         */
        private void Init()
        {
            _row_span = 1;
            _column_span = 1;
            _x = _y = _width = _height = 0;
        }
    }

    /**
     * The width of a column in pixels.
     */
    private int _column_width;

    /**
     * Layout constructor.
     *
     * @param context
     * @param attrs
     */
    public TilesLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TilesLayout, 0, 0);
        try
        {
            _column_width = a.getDimensionPixelSize(R.styleable.TilesLayout_column_width, 200);
        }
        finally
        {
            a.recycle();
        }
    }

    /**
     * @return the column_width
     */
    public int getColumnWidth()
    {
        return this._column_width;
    }

    /**
     * @param pColumnWidth
     *            the column_width to set
     */
    public void setColumnWidth(int pColumnWidth)
    {
        this._column_width = pColumnWidth;
        this.invalidate();
        this.requestLayout();
    }

    /**
     * A simple measurement using the padding and suggested sizes.
     *
     * @see android.view.View#onMeasure(int, int)
     */
    @SuppressLint("DrawAllocation")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        Log.d(TAG, "onMeasure: width - " + MeasureSpec.toString(widthMeasureSpec));
        Log.d(TAG, "onMeasure: height - " + MeasureSpec.toString(heightMeasureSpec));

        // compute the width we need
        int width = getPaddingLeft() + getPaddingRight() + getSuggestedMinimumWidth();
        width = Math.max(width, MeasureSpec.getSize(widthMeasureSpec));

        // compute the layout of all the children.
        LayoutProcessor processor = new LayoutProcessor(width);
        final int height = processor.MeasureAllChildren();

        // measure all the children (required so children render correctly).
        for(int i=0, c = getChildCount(); i < c; i++)
        {
            final View child = getChildAt(i);
            final TilesLayout.LayoutParams params = (TilesLayout.LayoutParams)child.getLayoutParams();
            final int cellWidthSpec = MeasureSpec.makeMeasureSpec(params._width, MeasureSpec.AT_MOST);
            final int cellHeightSpec = MeasureSpec.makeMeasureSpec(params._height, MeasureSpec.AT_MOST);
            child.measure(cellWidthSpec, cellHeightSpec);
        }

        // set out measure
        setMeasuredDimension(width, height);
    }

    /**
     * The minimum width should be at least the width of 1 column.
     *
     * @see android.view.View#getSuggestedMinimumWidth()
     */
    @Override
    protected int getSuggestedMinimumWidth()
    {
        return Math.max(super.getSuggestedMinimumWidth(), this._column_width);
    }

    /**
     * The minimum height should be at least the height of 1 column.
     *
     * @see android.view.View#getSuggestedMinimumHeight()
     */
    @Override
    protected int getSuggestedMinimumHeight()
    {
        return Math.max(super.getSuggestedMinimumHeight(), this._column_width);
    }

    /**
     * This layout positions the child views in the onSizeChanged event. Since
     * the position of children is directly related to the size of this view.
     *
     * @see android.view.ViewGroup#onLayout(boolean, int, int, int, int)
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom)
    {
        for (int i = 0, c = getChildCount(); i < c; i++)
        {
            final View child = getChildAt(i);

            TilesLayout.LayoutParams params = (TilesLayout.LayoutParams) child.getLayoutParams();
            child.layout(params._x, params._y, params._x + params._width, params._y + params._height);
        }
    }

    /**
     * Check if the parameters are our LayoutParam class. If this returns False
     * then the generateDefaultLayoutParams() method will be called.
     *
     * @see android.view.ViewGroup#checkLayoutParams(android.view.ViewGroup.LayoutParams)
     */
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p)
    {
        return p instanceof LayoutParams;
    }

    /**
     * Creates default layout parameters for child Views added to this
     * ViewGroup.
     *
     * @see android.view.ViewGroup#generateDefaultLayoutParams()
     */
    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new TilesLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    /**
     * This is used to create LayoutParams for child views. After this is called
     * the checkLayoutParams() is called to verify if the LayoutParams is
     * something this view can use. If not, then defaults will be created using
     * generateDefaultLayoutParams().
     *
     * @see android.view.ViewGroup#generateLayoutParams(android.util.AttributeSet)
     */
    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs)
    {
        return new TilesLayout.LayoutParams(getContext(), attrs);
    }

    /**
     * This is called to convert a LayoutParams that this View doesn't support
     * into one it does. This is called when the checkLayoutParams() false, and
     * LayoutParams need to be converted.
     *
     * @see android.view.ViewGroup#generateLayoutParams(android.view.ViewGroup.LayoutParams)
     */
    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p)
    {
        return new TilesLayout.LayoutParams(p.width, p.height);
    }

    /**
     * This class represents the algorithm used to position child views. The
     * algorithm uses counters for each column so fill gaps as child views span
     * across rows/columns.
     */
    private class LayoutProcessor
    {
        /**
         * Number of columns.
         */
        private int _column_count;

        /**
         * The width of each column.
         */
        private int _column_size;

        /**
         * The number of items in a column.
         */
        private int _columns[];

        /**
         * Constructor
         *
         * @param width
         *            The width of the layout.
         */
        public LayoutProcessor(int width)
        {
            // calculates the widest width a column can be so that they spac
            // across the entire View, but not so large 1 column exceeds the
            // width of the View.
            _column_count = Math.max(1, ((int) (width / _column_width)));
            _column_size = width / _column_count;
            _columns = new int[_column_count];
        }

        /**
         * Checks the spanning of a child to see if it fits in the current
         * cursor position across multiple columns.
         *
         * @param child
         *            The view to check.
         * @param row
         *            The row offset.
         * @param column
         *            The column offset.
         * @return True if it fits.
         */
        private boolean childFits(View child, int row, int column)
        {
            TilesLayout.LayoutParams params = (TilesLayout.LayoutParams) child.getLayoutParams();

            for (int i = column, c = column + Math.min(_column_count, params.getColumnSpan()); i < c; i++)
            {
                if (i == _column_count || _columns[i] > row)
                {
                    return false;
                }
            }

            return true;
        }

        /**
         * Positions the child by setting it's LayoutParams. The position is
         * calculated by the size of a column, and the row/column offset.
         *
         * @param child
         *            The child to position.
         * @param row
         *            The row offset.
         * @param column
         *            The column offset.
         *
         * @return The bottom of the view.
         */
        private int MeasureChild(View child, int row, int column)
        {
            TilesLayout.LayoutParams params = (TilesLayout.LayoutParams) child.getLayoutParams();

            final int col_span = Math.min(_column_count, params.getColumnSpan());
            final int row_span = params.getRowSpan();

            params._x = _column_size * column;
            params._y = _column_size * row;
            params._width = _column_size * col_span;
            params._height = _column_size * row_span;

            params._x += 4;
            params._y += 4;
            params._width -= 8;
            params._height -= 8;

            // increment the counters for each column this view covers
            for (int r = row, rc = row + row_span; r < rc; r++)
            {
                for (int c = column, cc = Math.min(column + col_span, _column_count + 1); c < cc; c++)
                {
                    _columns[c]++;
                }
            }

            child.setLayoutParams(params);

            return params._y + params._height;
        }

        /**
         * Processes all the child for the View until they are positioned into a
         * tile layout.
         *
         * @return The total height for the view.
         */
        public int MeasureAllChildren()
        {
            // a list of children marked True if it has been used.
            final int child_count = getChildCount();
            boolean done[] = new boolean[child_count];

            int offset = 0, row = 0, column = 0, height = 0;

            // Continue to layout children until all the children
            // have been positioned.
            while (offset < child_count)
            {
                // Starting from the offset try to find a child
                // that will fit. Continue to start from offset
                // until that child is positioned, and skip
                // over other child by checking `used[i]`
                int i;
                for (i = offset; i < child_count; i++)
                {
                    if (!done[i])
                    {
                        View child = getChildAt(i);

                        // Does this child have room to span across
                        // columns/rows?
                        if (childFits(child, row, column))
                        {
                            // position the child
                            final int bottom = MeasureChild(child, row, column);
                            height = Math.max(bottom, height);

                            // don't position this child again
                            done[i] = true;

                            break;
                        }
                    }
                }

                // move the offset to the next available child.
                while (offset < child_count && done[offset])
                {
                    offset++;
                }

                // move to the next column
                column++;

                // wrap to next row
                if (column == _column_count)
                {
                    column = 0;
                    row++;
                }
            }

            return height;
        }
    }
}