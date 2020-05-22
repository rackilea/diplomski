override fun onCreate(savedInstanceState: Bundle?) {
     /// *... blah blah my code no related to this issue*
    wv_contentArticle.loadUrl("file:///android_asset/articles/w.html") // loading file - just a test
    sv_contentPage.isSubmitButtonEnabled
    // bellow listen the searchview 

    sv_contentPage.setOnQueryTextListener(object :    SearchView.OnQueryTextListener {
        override fun onQueryTextChange(query: String): Boolean {
            return true
        }
        override fun onQueryTextSubmit(query: String): Boolean {

            if (!query.isEmpty()) {
                    sv_contentPage.clearFocus()  // to hide keyboard 
                    wv_contentArticle.findAllAsync(query) // look for string
                    try {
                        val m = WebView::class.java.getMethod("setFindIsUp", 
java.lang.Boolean.TYPE) // THIS WAS MISSING, WITHOUT IT THIS WILL NOT WORK
                        m.invoke(wv_contentArticle, true) // THIS WAS MISSING, WITHOUT IT THIS WILL NOT WORK

                    } catch (ignored: Throwable) {
                    }
            }
        return true
        }
    })
    bt_findNext.setOnClickListener {  wv_contentArticle.findNext(true)  } // find next one
    bt_findPrevious.setOnClickListener {  wv_contentArticle.findNext(false) } // find previous one
}