class TLabel extends JLabel{

    Token token;
    TLabel(Token token) {
        setToken(token);
    }

    void setToken(Token token) {

        this.token = token;
        setIcon(token.icon);
        setPreferredSize(new Dimension(
                token.icon.getIconWidth(), token.icon.getIconHeight()));
    }
    Token getToken() {
        return token;
    }

    Color getColor() {
        return token.color;
    }
}