FacesContext facesContext = FacesContext.getCurrentInstance();
XSPContext context = XSPContext.getXSPContext(facesContext);

String entryPage = context.getUrl().getPath() + context.getUrl().getQueryString();

if (entryPage.contains("/home.xsp")) {
    this.console("Entry Page contains /home.xsp");
    if (this.isBasicMode()) {
            entryPage.replace("home.xsp", "basic_Menu.xsp");
        }
    } else {
        this.console("entry page does NOT contain /home.xsp");
    }

context.redirectToPage(“/myPage.xsp”);


public void redirectExternal(String url) throws IOException {

    FacesContext fc = FacesContext.getCurrentInstance();
        ExtenalContext externalContext = fc.getExternalContext();
        externalContext.redirect(url);

    }

public void redirectToPage(final String pageName) {
        // pageName = "/myPage.xsp"

        try {
            // You'd think this would end all Java processing but that's NOT
            // what happens
            // It looks like the Java code will finish and only then will the
            // redirection happen.

            final String entryPage = JSFUtil.getXSPContext().getUrl().getPath() + JSFUtil.getXSPContext().getUrl().getQueryString();
            FrameworkUtils.getSessionScope().put("entryPage", entryPage);
            this.setEntryPage(entryPage);

            JSFUtil.getXSPContext().redirectToPage(pageName);

        } catch (final RedirectSignal rs) {
            // Ignoring this error. Useless!
        }
        // Returning false so we can stop the calling code from continuing
        // return false;

    }

    public String getParam(final String key) {
        if (!this.getQueryString().containsKey(key)) {
            return null;
        } else {
            return this.getQueryString().get(key);
        }

    }


    @SuppressWarnings("unchecked")
    public Map<String, String> getQueryString() {
        final Map<String, String> qs = (Map<String, String>) FrameworkUtils.resolveVariable("param");
        return qs;
    }