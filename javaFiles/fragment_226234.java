class TypefaceProvider {
    companion object {
        private var tmpTypeface = Hashtable<String, Typeface>()
        @JvmStatic
        fun getTypeface(context: Context, dir: String, name: String): Typeface {
            val createTypeface = tmpTypeface[name] ?: try {
                Typeface.createFromAsset(context.assets, "$dir/$name")
            } catch (e: Exception) {
                Log.e(TAG, "fail. msg:${e.message}")
                Typeface.DEFAULT
            }
            tmpTypeface[name] = createTypeface`
            return createTypeface
        }
    }
}