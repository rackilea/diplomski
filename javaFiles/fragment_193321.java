public class setTextViewCatalogue {

    private String mColorImg;
    private String mNomeColore;
    private String mCodiceColore;
    ClickHandler callback;

    public setTextViewCatalogue(String colorImg, String nomeColore, String codiceColore, ClickHandler callback) {
        mColorImg = colorImg;
        mNomeColore = nomeColore;
        mCodiceColore = codiceColore;
        this.callback = callback;
    }

    public void clicked(){ callback.onClick(); }

    public String getColorImg() {return mColorImg;}
    public String getNomeColore() {return mNomeColore;}
    public String getCodiceColore() {return mCodiceColore;}

}