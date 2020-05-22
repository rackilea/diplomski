activity.launch(Dispatchers.Main) {
    textView.text = requestStringFromNetwork()
}

...

suspend fun requestStringFromNetwork() = suspendCancellableCoroutine<String> {
    ...
}