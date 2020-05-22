class SingleKotlin private constructor(){
    companion object {
        @JvmStatic
        val instance by lazy {
            SingleKotlin()
        }
    }
}