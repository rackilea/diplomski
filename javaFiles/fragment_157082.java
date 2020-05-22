/**
 * Deletes the session state by deleting the file. Useful during development
 * when restoring to old state is not always the desired behaviour.
 * Pending: this is incomplete, deletes the mainframe state only.
 */
protected void deleteSessionState() {
    ApplicationContext context = getContext();
    try {
        context.getLocalStorage().deleteFile("mainFrame.session.xml");
    } catch (...) {
    }
}