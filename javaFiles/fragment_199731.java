private Clob sut;

        try {
            if( sut != null )
            {
                return sut.getSubString(1,(int) sut.length());
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }
    public void setSutString(String str)
    {
        Clob newValue = new ClobImpl(str);
    this.setSut( newValue );
    }

    public Clob getSut() {
        return sut;
    }

    public void setSut(Clob sut) {
        this.sut = sut;
    }