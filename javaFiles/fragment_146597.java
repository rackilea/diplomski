public enum Note {
DO
{
    @Override
    public String getNote() {return "do";}
    @Override
    public String getText() {return "DO";}
    @Override
    public Color getColor() {return new Color(255, 255, 255);}
},
RE
{...},
...
SI
{...};

 abstract String getNote()
 abstract String getText()
 abstract String getColor()
}