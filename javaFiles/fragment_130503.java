@Override
protected PageList onNewRootPageList() {

    return new PageList(
            new LoginInfoPage(this, "Login Information").setRequired(true));
}