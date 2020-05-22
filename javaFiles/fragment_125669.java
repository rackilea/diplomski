@Inject MainActivityPresenter presenter    

override fun onCreate(savedInstanceState: Bundle) {
   super.onCreate(savedInstanceState)
   (application as App).component.inject(this)

   // after #inject(this) above you can start using your injections:

   presenter.getUser()
}