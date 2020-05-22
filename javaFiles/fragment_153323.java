public String login() {
    // ...

    request.login(username, password);

    // ...

    return "index.jsf?faces-redirect=true";
}