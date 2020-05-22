Future<String> result = (Future<String>) request.getSession().getAttribute("result");

if (result != null) {
    if (!result.isDone() && userWantsToCancel) {
        result.cancel();
    }
}