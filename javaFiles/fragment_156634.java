protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    scope.enter(this);
    try {

        ...

    } finally {
        scope.exit(this);
    }
}