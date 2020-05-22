override fun onDraw(canvas: Canvas) {
   super.onDraw(canvas)

   val centerX = width / 2
   val centerY = height / 2
   val radius = width / 2
   canvas.drawCircle(centerX.toFloat(), centerY.toFloat(), radius.toFloat(), paint)
}