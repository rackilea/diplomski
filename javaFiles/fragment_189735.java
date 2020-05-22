override fun onBackPressed() {
    val currentDestination=NavHostFragment.findNavController(nav_host_fragment).currentDestination
    when(currentDestination.id) {
        R.id.loginFragment -> {
            finish()
        }
    }
    super.onBackPressed()
}