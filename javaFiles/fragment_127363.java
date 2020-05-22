public void multiplication(){
    for (int cm = 0; cm < 5; cm++) {
        for (int cn = 0; cn < 5; cn++) {
            int result = 0;
            for (int i = 0; i < 5; i++) {
                result += this.matriz1[cm][i] * this.matriz2[i][cn];
            }
            this.multi[cm][cn] = result;
        }
    }
}