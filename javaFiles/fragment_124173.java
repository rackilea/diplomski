... inside your view class
val pref = PreferenceManager.getDefaultSharedPreferences(context).getString(PREF_KEY_NAME, null)

viewModel.yourMethod(pref)

... inside your viewmodel class
fun yourMethod(pref: String?) {
    repository.doSomething(pref)
}

... inside your repository/data source class
fun doSomething(pref: String?) {
    // whatever you need to do with this pref. 
    // e.g. api call
    api.doMethod(pref)
}