/**
 * reduces the size of the image
 * @param image
 * @param maxSize
 * @return
 */
fun getResizedBitmap(image: Bitmap, maxSize: Int): Bitmap {
    var width: Int = image.width
    var height: Int = image.height

    val bitmapRatio: Double = (width / height).toDouble()
    if (bitmapRatio > 1) {
        width = maxSize
        height = (width / bitmapRatio).toInt()
    } else {
        height = maxSize
        width = (height * bitmapRatio).toInt()
    }
    return Bitmap.createScaledBitmap(image, width, height, true)
}