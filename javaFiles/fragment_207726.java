fun onResume() {
    super.onResume()
    // start listening and execute
    realmListener.forEach { it.attach() }
}

fun onPause() {
    // stop listening
    realmListener.forEach { it.detach() }
    super.onPause()
}