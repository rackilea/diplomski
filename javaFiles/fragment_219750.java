override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var recyclerview_newmessage = RecyclerView(this)
        setContentView(recyclerview_newmessage) . // add this line
        supportActionBar?.title = "Select User"

        fetchUsers()
      }