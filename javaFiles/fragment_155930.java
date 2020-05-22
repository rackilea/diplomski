mMatrix.reset();
mMatrix.postRotate(Degrees, _spriteWidth / 3, _spriteHeight / 2);
mMatrix.postTranslate(current_Position.x, current_Position.y);

this._modified_bitmap = Bitmap.createBitmap(_bitmap, 0, 0, _spriteWidth, _spriteHeight);

canvas.drawBitmap(_modified_bitmap, mMatrix, null);