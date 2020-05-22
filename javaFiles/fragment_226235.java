class TypefaceProvider {
    companion object {
        private var tmpTypeface = Hashtable<String, Typeface>()

        private fun loadTypeFace(context: Context, dir: String, name: String): Typeface {
            val typeface = try {
                Typeface.createFromAsset(context.assets, "$dir/$name")
            } catch (e: Exception) {
                Typeface.DEFAULT
            }
            tmpTypeface[name] = typeface
            return typeface
        }

        @JvmStatic
        fun getTypeface(context: Context, dir: String, name: String) = 
            tmpTypeface[name] ?: loadTypeFace(context, dir, name)
    }
}