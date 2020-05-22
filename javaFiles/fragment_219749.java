override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.ref_xml_file) . // add this line
    supportActionBar?.title = "Select User"

    fetchUsers()
  }