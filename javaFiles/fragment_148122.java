fun drawTile() {
        var number = tile.number
        var cordX = tile.x
        var cordY = tile.y

        shapeDrawable = ShapeDrawable(RectShape())
        shapeDrawable.setBounds(cordX, cordY, tileWidth, tileHeight)

        shapeDrawable.getPaint().color = tile.tileColor

        shapeDrawable.draw(canvas)
        if(number != 0) {

            var paintText = Paint(Paint.ANTI_ALIAS_FLAG)
            paintText.color = Color.BLACK
            paintText.textSize = 50f

            val numberString = "$number"

            paintText.setShadowLayer(10f, 10f, 10f, Color.BLACK)

            canvas.drawText(numberString, cordX.toFloat() + tileWidth/2, cordY.toFloat() + tileHeight / 2, paintText) 

        }