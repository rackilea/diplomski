@Override
    public boolean equals(Object obj) {
        if (!obj instanceof Dogs){
            return false;
        }
        return this.dogKind.equals(((Dogs)obj).getDogKind());
    }