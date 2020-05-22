override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
        android.R.id.home -> {
            finish()
            return true
        }
    }
    return super.onOptionsItemSelected(item)
}