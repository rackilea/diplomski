import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.annotation.Nullable

class Panel : View, View.OnTouchListener {

var paint: Paint? = null
var point1: Point? = null
var point2:Point? = null

var path: Path = Path()

var paths: ArrayList<Path> = ArrayList()

init {
    paint = Paint()
    paint?.color = Color.GREEN
    paint?.strokeWidth = 10f
    paint?.style = Paint.Style.STROKE
    this.setOnTouchListener(this)
}


constructor(context: Context): super(context)

constructor(context: Context, @Nullable attrs: AttributeSet): super(context, attrs)

override fun onDraw(canvas: Canvas) {
    canvas.drawColor(Color.BLACK)
    paint?.let {
        for (path in paths) {
            canvas.drawPath(path, it)
        }
    }
}

override fun onTouch(view: View, event: MotionEvent): Boolean {

    if (event.action == MotionEvent.ACTION_DOWN) {
        point1 = Point()
        point1?.x = event.x.toInt()
        point1?.y = event.y.toInt()

        path.moveTo((point1?.x?:0)*1f, (point1?.y?:0)*1f)
    } else if (event.action == MotionEvent.ACTION_MOVE) {

        point2 = Point()
        point2?.x = event.x.toInt()
        point2?.y = event.y.toInt()


        path.lineTo((point2?.x?:0)*1f, (point2?.y?:0)*1f)
        path.let {
            paths.add(it)
        }
        invalidate()
    }
    return true
}
}