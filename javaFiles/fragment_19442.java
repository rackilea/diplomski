class Steam(path: String? = null) {
    val location: File = if (path != null) {
        checkSteamIsThere(path) // throws if it isn't
        File(path)
    } else {
        locateSteam() // throws an exception if it can't locate Steam
    }
}