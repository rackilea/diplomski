class AccountTemplate {
    protected JFrame frame;

    public String getGradesBtnnName() {
        return "Grades";
    }

    public String getArticlesBtnName() {
        return "Articles";
    }

    public ActionListener getArticlesListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmAccountTemplate.dispose();
                AccountLogin.main(null);
            }
        });
    }

    protected void initialize() {
        frame = new JFrame("");
        // .....
        JButton btnGrades = new JButton(getGradesBtnnName());
        // .....
        JButton btnArticles = new JButton(getArticlesBtnName());
        btnArticles.addActionListener(getArticlesListener())
        // ....
    }